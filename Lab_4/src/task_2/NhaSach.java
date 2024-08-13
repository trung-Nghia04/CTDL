package task_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class NhaSach {
	public static void main(String[] args) {
		ChuongSach c1 = new ChuongSach("chuong 1", 10);
		ChuongSach c2 = new ChuongSach("chuong 2", 14);
		ChuongSach c3 = new ChuongSach("chuong 3", 9);
		ChuongSach c4 = new ChuongSach("chuong 4", 5);
		ChuongSach c5 = new ChuongSach("chuong 5", 20);
		ChuongSach c6 = new ChuongSach("chuong 6", 10);

		TapChi tc1 = new TapChi("thoi trang", 20, 2010, "NVA", 50, "T1");
		TapChi tc2 = new TapChi("the thao", 15, 2023, "NVC", 30, "T2");
		TapChi tc3 = new TapChi("thoi trang", 10, 2010, "NVA", 75, "T3");

		SachThamKhao s1 = new SachThamKhao("Sach tham khao 3", 60, 2000, "A", 100, "Thể thao");
		s1.themChuongSach(c1);
		s1.themChuongSach(c2);
		SachThamKhao s2 = new SachThamKhao("Sach tham khao 2", 600, 2023, "D", 170, "Giáo dục");
		s2.themChuongSach(c1);
		s2.themChuongSach(c2);
		s2.themChuongSach(c3);
		s2.themChuongSach(c4);
		SachThamKhao s3 = new SachThamKhao("Sach tham khao 1", 300, 2020, "F", 300, "Y tế");
		s3.themChuongSach(c1);
		s3.themChuongSach(c2);
		s3.themChuongSach(c3);
		s3.themChuongSach(c4);
		s3.themChuongSach(c5);
		s3.themChuongSach(c6);

		DanhMucAnPham dm1 = new DanhMucAnPham();
		dm1.themAnPham(s1);
		dm1.themAnPham(s2);
		dm1.themAnPham(s3);
		dm1.themAnPham(tc1);
		dm1.themAnPham(tc2);
		dm1.themAnPham(tc3);

		System.out.println("===============lay loai an pham=================");
		System.out.println(s1.layLoaiAnPham());
		System.out.println("===============tạp chí và có thời gian xuất bản cách đây(2021) 10 năm=================");
		System.out.println(tc1.kiemTraTapChi());
		System.out.println("===============thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả=================");
		System.out.println(dm1.kiemTraCungLoaiTacGia(tc3, tc1));
		System.out.println("===============tổng tiền của tất các ấn phẩm trong nhà sách=================");
		System.out.println(dm1.tongTien());
		System.out.println("===============Tìm quyển sách tham khảo có chương sách nhiều trang nhất=================");
		System.out.println(dm1.sachCoChuongNhieuTrang());
		System.out.println(
				"===============Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay không?=================");
		System.out.println(dm1.coTapChiChoTruoc("T2"));
		System.out.println(
				"===============Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước=================");
		System.out.println(dm1.danhSachTapChiTheoNam(2010));
		System.out.println(
				"===============Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản===============");
		dm1.sapXep();
		System.out.println(dm1);
		System.out.println("===============Thống kê số lượng ấn phẩm theo năm xuất bản.=================");
		Map<Integer, Integer> re = dm1.thongKeTheoNamXB();
		for (Integer key : re.keySet()) {
			System.out.println("Key: " + key + ", Value: " + re.get(key));
		}
		System.out.println("===============Nhóm các ấn phẩm theo thể loại.=================");
		Map<String, ArrayList<AnPham>> re2 = dm1.nhomAnPhamTheoLoai();
		for (String key : re2.keySet()) {
			System.out.println("Key: " + key + ", Value: " + re2.get(key));
		}
		System.out.println("===============Nhóm các ấn phẩm theo số trang=================");
		Map<Boolean, ArrayList<AnPham>> re3 = dm1.nhomAnPhamTheoTrang();
		for (Boolean key : re3.keySet()) {
			System.out.println("Key: " + key + ", Value: " + re3.get(key));
		}

	}
}
