create database swingDTBConnector
go
use swingDTBConnector
go
-- Tao bang user
create table NguoiDung(
	ID int identity(1,1) primary key,
	Ten nvarchar(45),
	Sdt varchar(45),
	TenTK varchar(45),
	Matkhau varchar(45),
	GioiThieu nvarchar(100),
	VaiTro nvarchar(45),
	SoThich nvarchar(45)
)
go
insert into NguoiDung (Ten,Sdt,TenTK,Matkhau,GioiThieu,VaiTro,SoThich) values
	(N'Nguy?n A',0905123456,'abc',12345,null,null,N'Xem Phim'),
	(N'Lê B',0905123457,'abc',12345,null,null,N'Xem Phim'),
	(N'Trần C',0905123458,'abc',12345,null,null,N'Ăn'),
	(N'Đinh D',0905123459,'abc',12345,null,null,N'Ngủ')

-- Product
create table SanPham
(
	maSP char(5) not null,
	tenSP nvarchar(50) not null,
	donGiaBan money not null,
	tenNSX nvarchar(50),
	soLuongHienCon int
)

insert into SanPham(maSP,TenSP,donGiaBan,tenNSX ,soLuongHienCon)
values  ('SP001',N'Fanta',200000,N'PepsiCo',500),
        ('SP002',N'ChocoPie',40000,N'Orion',10),
        ('SP003',N'Cocacola',310000,N'PepsiCo',22),
        ('SP004',N'Kẹo',500000,N'Oishi',100),
        ('SP005',N'Sữa Vinamilk',30000,N'Vinamilk',123)

go
use swingDTBConnector
go

create or alter function FN_idNextSanPham
()
returns char(5)
as
begin
	declare @id char(5)
	select top 1  @id=maSP
	from SanPham
	order by maSP desc
	declare @lastnumber int
	set @lastnumber=right(@id,3)+1
	declare @nextchar char(5)
	set @nextchar=CONCAT('SP', format (@lastnumber, 'D3'))
	return @nextchar
end
go