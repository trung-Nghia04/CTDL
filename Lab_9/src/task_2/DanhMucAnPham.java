package task_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	private List<AnPham> dmAnPham;

	public DanhMucAnPham() {
		dmAnPham = new ArrayList<>();
	}

	public void themAnPham(AnPham p) {
		dmAnPham.add(p);
	}

	public String toString() {
		return "DanhMucAnPham [danhSachAnPham=" + dmAnPham + "]";
	}

	public void removePublication(AnPham p) {
		dmAnPham.remove(p);
	}

	public boolean kiemTraTapChiSanXuat(AnPham p) {
		if (p instanceof TapChi) {
			if (p.getNamXuatBan() <= 2021) {
				return true;
			}
		}
		return false;
	}

	public boolean kiemTraCungLoaiVaTacGia(AnPham p1, AnPham p2) {
		if (p1.getTacGia().equals(p2.getTacGia())) {
			if (p1.getType().equals(p2.getType())) {
				return true;
			}
		}
		return false;
	}

	public double tongTien() {
		double totalPrice = 0;
		for (AnPham p : dmAnPham) {
			totalPrice += p.getGia();
		}
		return totalPrice;
	}

	public SachThamKhao sachCoNhieuChuongNhat() {
		SachThamKhao longestChapterBook = null;
		int longestChapterPages = 0;
		for (AnPham p : dmAnPham) {
			if (p instanceof SachThamKhao) {
				SachThamKhao rb = (SachThamKhao) p;
				for (ChuongSach c : rb.getDsChuonhg()) {
					if (c.getSoTrang() > longestChapterPages) {
						longestChapterBook = rb;
						longestChapterPages = c.getSoTrang();
					}
				}
			}
		}
		return longestChapterBook;
	}

	public boolean timTapChiChoTruoc(String name) {
		for (AnPham p : dmAnPham) {
			if (p instanceof TapChi) {
				TapChi m = (TapChi) p;
				if (m.getTen().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	public List<TapChi> layDanhSachTapChiTheoNam(int year) {
		List<TapChi> magazines = new ArrayList<>();
		for (AnPham p : dmAnPham) {
			if (p instanceof TapChi) {
				TapChi m = (TapChi) p;

				if (m.getNamXuatBan() == year) {

					magazines.add(m);
				}
			}
		}

		return magazines;
	}

	public void sapXepAnPham() {
		Collections.sort(dmAnPham, new Comparator<AnPham>() {
			@Override
			public int compare(AnPham o1, AnPham o2) {
				int compareByTitle = o1.getTieuDe().compareTo(o2.getTieuDe());
				if (compareByTitle != 0) {
					return compareByTitle;
				}
				return Integer.compare(o2.getNamXuatBan(), o1.getNamXuatBan());
			}
		});
	}

	public void thongKeSoLuongTheoNam() {
		Map<Integer, Integer> thongKeNamXuatBan = new HashMap<>();
		for (AnPham anPham : dmAnPham) {
			int namXuatBan = anPham.namXuatBan;
			thongKeNamXuatBan.put(namXuatBan, thongKeNamXuatBan.getOrDefault(namXuatBan, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : thongKeNamXuatBan.entrySet()) {
			System.out.println("Năm " + entry.getKey() + ": " + entry.getValue() + " ấn phẩm");
		}
	}

}
