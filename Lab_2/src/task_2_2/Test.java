package task_2_2;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		SanPham sp1 = new SanPhamTrongNuoc("chuoc", "trong nuoc", 100);
		SanPham sp2 = new SanPhamTrongNuoc("ban phim", "trong nuoc", 150);
		SanPham sp3 = new SanPhamTrongNuoc("man hinh", "trong nuoc", 200);
		SanPham sp4 = new SanPhamNhapKhau("man hinh", "nhap khau", 300, "Trung Quoc");
		SanPham sp5 = new SanPhamNhapKhau("tai nghe", "nhap khau", 200, "Trung Quoc");
		SanPham sp6 = new SanPhamNhapKhau("dien thoai", "nhap khau", 500, "Han Quoc");

		CTHoaDon ctHD1 = new CTHoaDon(sp1, 4);
		CTHoaDon ctHD2 = new CTHoaDon(sp4, 2);
		CTHoaDon ctHD3 = new CTHoaDon(sp3, 7);
		CTHoaDon ctHD4 = new CTHoaDon(sp2, 4);
		CTHoaDon ctHD5 = new CTHoaDon(sp5, 1);
		CTHoaDon ctHD6 = new CTHoaDon(sp6, 8);

		HoaDon hd1 = new HoaDon("001", "DTA", "NVA", new Date(2024, 07, 01));
		HoaDon hd2 = new HoaDon("001", "DTB", "NVB", new Date(2024, 03, 16));

		hd1.themCtHoaDon(ctHD1);
		hd1.themCtHoaDon(ctHD2);
		hd1.themCtHoaDon(ctHD3);

		hd2.themCtHoaDon(ctHD4);
		hd2.themCtHoaDon(ctHD5);
		hd2.themCtHoaDon(ctHD6);

		System.out.println(hd1);
		System.out.println("-------------------------------------");
		System.out.println(hd2);
		System.out.println("-------------------------------------");

		System.out.println("sp1: " + sp1);
		sp1.tangGia();
		System.out.println("sau tang gia: " + sp1);
		System.out.println("-------------------------------------");
		System.out.println("san pham sp1 nhap khau: " + sp1.kiemTraNguonGoc());
		System.out.println("san pham sp6 nhap khau: " + sp6.kiemTraNguonGoc());
		System.out.println("-------------------------------------");
		System.out.println(
				"sản phẩm là trong nước và có giá cao hơn mức giá cho trước hay không: " + sp1.kiemTraSPTrongNuoc(100));
		System.out.println("-------------------------------------");
		System.out.println("tong tien hoa don hd1: " + hd1.cost());
		System.out.println("-------------------------------------");
		System.out.println("sản phẩm có số lượng bán ra nhiều nhất hd1: " + hd1.banNhiuNhat());
		System.out.println("-------------------------------------");
		System.out.println("hd1 co chua san pham sp1: " + hd1.coChuaSP(sp1));
		System.out.println("-------------------------------------");
		System.out.println("danh sach cac san pham nhap khau cua hd2: \n" + hd2.dsSanPhamNhapKhau());
		System.out.println("-----------------------------------------");
		System.out.println("sap xep: ");
		hd1.sapXep();
		System.out.println(hd1);
	}
}
