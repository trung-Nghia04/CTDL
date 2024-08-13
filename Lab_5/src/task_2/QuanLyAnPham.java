package task_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuanLyAnPham {
	private List<AnPham> anPhams = new ArrayList<>();

//	Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
	public boolean cungloaiTacGia(AnPham o1, AnPham o2) {
		return o1.getClass().equals(o2.getClass()) && o1.cungTacGia(o2);
	}

//
//	Tính tổng tiền của tất các ấn phẩm trong nhà sách
	public int tongTien() {
		return anPhams.stream().mapToInt(AnPham::getGiaTien).sum();
	}

//	Tìm quyển sách tham khảo có chương sách nhiều trang nhất?
	public AnPham sachCoChuongNhieuTrang() {
		Comparator<AnPham> comp = (o1, o2) -> {
			SachThamKhao tk1 = (SachThamKhao) o1;
			SachThamKhao tk2 = (SachThamKhao) o2;
			return Long.compare(tk1.chuongSachNhieuTrangNhat().getSoTrang(),
					tk2.chuongSachNhieuTrangNhat().getSoTrang());
		};
		return anPhams.stream().filter(x -> x instanceof SachThamKhao).max(comp).get();
	}

	// Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay
	// không?
	public boolean coTapChiChoTruoc(String name) {
		return anPhams.stream().filter(x -> x instanceof TapChi).filter(x -> ((TapChi) x).getTenTapChi().equals(name))
				.count() != 0;
	}

//	Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
	public List<AnPham> dsTapChiTrongNam(int year) {
		return anPhams.stream().filter(x -> x instanceof TapChi).filter(x -> (x.getNamXB() == year)).toList();
	}

//	Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản (sử dụng
//			interface Comparable hoặc Comparator)
	public void sapXep() {
		Comparator<AnPham> comp = Comparator.comparing(AnPham::getTieuDe).thenComparing(AnPham::getNamXB,
				Comparator.reverseOrder());
		anPhams.sort(comp);
	}

	public Map<Integer, Long> thongKeSoLuongAnPhamTheoNamXuatBan() {
		return anPhams.stream().collect(Collectors.groupingBy(AnPham::getNamXB, Collectors.counting()));
	}

	public void themAnPham(AnPham s1) {
		this.anPhams.add(s1);

	}

	@Override
	public String toString() {
		return "DanhMucAnPham: \n" + anPhams;
	}

}
