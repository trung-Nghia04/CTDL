package task_2_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class HoaDon {
	private String id, tenNV, tenKH;
	private Date ngayLapHoaDon;
	private List<CTHoaDon> dsCTHoaDon = new ArrayList<>();

	public HoaDon(String id, String tenNV, String tenKH, Date ngayLapHoaDon) {
		this.id = id;
		this.tenNV = tenNV;
		this.tenKH = tenKH;
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public void themCtHoaDon(CTHoaDon ct) {
		this.dsCTHoaDon.add(ct);
	}

	public int cost() {
		int sum = 0;
		for (CTHoaDon cth : dsCTHoaDon) {
			sum += cth.cost();
		}
		return sum;
	}

	public SanPham banNhiuNhat() {
		CTHoaDon re = dsCTHoaDon.get(0);
		for (CTHoaDon cth : dsCTHoaDon) {
			if (cth.soLuongBanNhieuHon(re))
				re = cth;
		}
		return re.getThongTinSanPham();
	}

	public boolean coChuaSP(SanPham that) {
		for (CTHoaDon cth : dsCTHoaDon) {
			return cth.cungTen(that);
		}
		return false;
	}

	public ArrayList<SanPham> dsSanPhamNhapKhau() {
		ArrayList<SanPham> re = new ArrayList<>();
		for (CTHoaDon cth : dsCTHoaDon) {
			if (cth.laNhapKhau())
				re.add(cth.getThongTinSanPham());
		}
		return re;
	}

	public void sapXep() {
		Collections.sort(dsCTHoaDon, new Comparator<CTHoaDon>() {

			@Override
			public int compare(CTHoaDon o1, CTHoaDon o2) {
				int re = o2.getThongTinSanPham().tenSP.compareTo(o2.getThongTinSanPham().tenSP);
				if (re == 0) {
					return o1.getSoLuongMua() - o2.getSoLuongMua();
				}
				return re;
			}
		});
	}

	@Override
	public String toString() {
		return "HoaDon: " + id + ", tenNV: " + tenNV + ", tenKH: " + tenKH + ", ngayLapHoaDon: " + ngayLapHoaDon + "\n"
				+ ", dsCTHoaDon: " + dsCTHoaDon;
	}

}
