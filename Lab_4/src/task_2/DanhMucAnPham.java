package task_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	private List<AnPham> anPhams = new ArrayList<>();

	public DanhMucAnPham() {
	}

	public void themAnPham(AnPham a) {
		this.anPhams.add(a);
	}

	// kiem tra 2 an pham co cung loai va tac gia khong
	public boolean kiemTraCungLoaiTacGia(AnPham o1, AnPham o2) {
		return o1.getClass().equals(o2.getClass()) && o1.getTacGia().equals(o2.getTacGia());
	}

	// tinh tong tien
	public double tongTien() {
		int sum = 0;
		for (AnPham ap : anPhams) {
			sum += ap.getGiaTien();
		}
		return sum;
	}

	// Tìm quyển sách tham khảo có chương sách nhiều trang nhất
	public SachThamKhao sachCoChuongNhieuTrang() {
		SachThamKhao re = null;
		int max = 0;
		for (int i = 0; i < anPhams.size(); i++) {
			AnPham ai = anPhams.get(i);
			if (ai.layLoaiAnPham().equals("Sach tham khao")) {
				SachThamKhao si = (SachThamKhao) ai;
				if (si.laySoTrangLonNhat() > max) {
					max = si.laySoTrangLonNhat();
					re = si;
				}
			}
		}
		return re;
	}

	// Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay
	// không?
	public boolean coTapChiChoTruoc(String name) {
		for (AnPham ap : anPhams) {
			if (ap.tapChiCungTen(name))
				return true;
		}
		return false;
	}

//	Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
	public List<TapChi> danhSachTapChiTheoNam(int nam) {
		List<TapChi> re = new ArrayList<>();
		for (AnPham ap : anPhams) {
			if (ap.layLoaiAnPham().equals("Tap chi") && ap.getNamXB() == nam)
				re.add((TapChi) ap);

		}
		return re;
	}

	public void sapXep() {
		Collections.sort(anPhams, new Comparator<AnPham>() {

			@Override
			public int compare(AnPham o1, AnPham o2) {
				int soSanhTieuDe = o1.getTieuDe().compareTo(o2.getTieuDe());
				if (soSanhTieuDe == 0) {
					return Integer.compare(o1.getNamXB(), o2.getNamXB());
				}
				return soSanhTieuDe;
			}
		});
	}

	// Thống kê số lượng ấn phẩm theo năm xuất bản. Ví dụ 2020: 5, 2021: 10, ... năm
	// 2020 có 5 ấn phẩm, năm 2021 có 10 ấn phẩm.

	public Map<Integer, Integer> thongKeTheoNamXB() {
		Map<Integer, Integer> re = new HashMap<>();
		for (AnPham ap : anPhams) {
			re.put(ap.getNamXB(), re.getOrDefault(ap.getNamXB(), 0) + 1);
		}
		return re;
	}

	// Nhóm các ấn phẩm theo thể loại.
	public Map<String, ArrayList<AnPham>> nhomAnPhamTheoLoai() {
		Map<String, ArrayList<AnPham>> re = new HashMap<>();
		for (AnPham ap : anPhams) {
			if (ap.layLoaiAnPham().equals("Tap chi")) {
				ArrayList<AnPham> val = re.getOrDefault("Tap chi", new ArrayList<>());
				val.add(ap);
				re.put("Tap chi", val);
			} else {
				ArrayList<AnPham> val2 = re.getOrDefault("Sach tham khao", new ArrayList<>());
				val2.add(ap);
				re.put("Sach tham khao", val2);
			}
		}
		return re;
	}

//	Nhóm các ấn phẩm theo số trang, với key là true dành cho các ấn phẩm có trên 500
//	trang, key là false dành cho các ấn phẩm còn lại; value là các ấn phẩm tương ứng.
	public Map<Boolean, ArrayList<AnPham>> nhomAnPhamTheoTrang() {
		Map<Boolean, ArrayList<AnPham>> re = new HashMap<>();
		for (AnPham ap : anPhams) {
			if (!ap.sachTren500Trang()) {
				ArrayList<AnPham> val = re.getOrDefault(false, new ArrayList<>());
				val.add(ap);
				re.put(false, val);
			} else {
				ArrayList<AnPham> val2 = re.getOrDefault(true, new ArrayList<>());
				val2.add(ap);
				re.put(true, val2);
			}

		}
		return re;
	}

	@Override
	public String toString() {
		return "DanhMucAnPham: \n" + anPhams;
	}

}
