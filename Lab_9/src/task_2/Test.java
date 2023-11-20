package task_2;

public class Test {
	public static void main(String[] args) {
		DanhMucAnPham anPham = new DanhMucAnPham();

		ChuongSach c1 = new ChuongSach("Mở đầu", 20);
		ChuongSach c2 = new ChuongSach("Thân bài", 40);
		ChuongSach c7 = new ChuongSach("Mở đầu", 10);
		ChuongSach c8 = new ChuongSach("Thân bài", 280);
		ChuongSach c9 = new ChuongSach("Kết thúc", 10);

		TapChi t1 = new TapChi("Tap chi 1", 50, 2011, "A", 100, "Bóng đá");
		TapChi t2 = new TapChi("Tap chi 3", 100, 2000, "A", 50, "Vui chơi");
		TapChi t3 = new TapChi("Tap chi 2", 200, 2000, "B", 70, "Tình nguyện");

		SachThamKhao s1 = new SachThamKhao("Sach kham kho 3", 60, 2000, "A", 100, "Thể thao");
		SachThamKhao s2 = new SachThamKhao("Sach kham kho 2", 70, 2023, "D", 170, "Giáo dục");
		SachThamKhao s3 = new SachThamKhao("Sach kham kho 1", 300, 2020, "F", 300, "Y tế");

		anPham.themAnPham(t1);
		anPham.themAnPham(t2);
		anPham.themAnPham(t3);
		anPham.themAnPham(s1);
		anPham.themAnPham(s2);
		anPham.themAnPham(s3);

		s1.themChuong(c1);
		s1.themChuong(c2);
		s2.themChuong(c1);
		s2.themChuong(c2);
		s2.themChuong(c9);
		s3.themChuong(c7);
		s3.themChuong(c8);
		s3.themChuong(c9);

		System.out.println("6) Xác định loại của ấn phẩm (Tạp chí hay Sách tham khảo) :");
		System.out.println("t1 là loại: " + t1.getType());
		System.out.println("s1 là loại: " + s1.getType() + "\n");

		System.out.println("7) Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây \r\n"
				+ "(2021) 10 năm hay không:");
		System.out.println("Kiểm tra tạp chí t1: " + anPham.kiemTraTapChiSanXuat(t1));
		System.out.println("Kiểm tra tạp chí t2: " + anPham.kiemTraTapChiSanXuat(t2) + "\n");

		System.out.println("8) Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không: ");
		System.out.println("Kiểm tra t1 và t2: " + anPham.kiemTraCungLoaiVaTacGia(t1, t2));
		System.out.println("Kiểm tra s1 và t1: " + anPham.kiemTraCungLoaiVaTacGia(s1, t1) + "\n");

		System.out.println("9) Tính tổng tiền của tất các ấn phẩm trong nhà sách: ");
		System.out.println(anPham.tongTien() + "\n");

		System.out.println("10) Tìm quyển sách tham khảo có chương sách nhiều trang nhất: ");
		System.out.println(anPham.sachCoNhieuChuongNhat() + "\n");

		System.out.println(
				"11) Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước \r\n" + "hay không?");
		System.out.println(anPham.timTapChiChoTruoc("Bóng đá") + "\n");

		System.out.println("12) Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước :");
		System.out.println(anPham.layDanhSachTapChiTheoNam(2000) + "\n");

		System.out.println("13) Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản:");
		anPham.sapXepAnPham();
		System.out.println(anPham + "\n");

		System.out.println("14) Thống kê số lượng ấn phẩm theo năm xuất bản:");
		anPham.thongKeSoLuongTheoNam();
	}

}
