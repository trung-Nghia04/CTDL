package task_2;

import java.util.ArrayList;
import java.util.List;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> chuongSachs = new ArrayList<>();

	public SachThamKhao(String tieuDe, int soTrang, int namXB, String tacGia, double giaTien, String linhVuc) {
		super(tieuDe, soTrang, namXB, tacGia, giaTien);
		this.linhVuc = linhVuc;
	}

	public void themChuongSach(ChuongSach c) {
		this.chuongSachs.add(c);
	}

	@Override
	public String toString() {
		return "AnPham: " + tieuDe + ", soTrang: " + soTrang + ", namXB: " + namXB + ", tacGia: " + tacGia
				+ ", giaTien: " + giaTien + " SachThamKhao: \n" + linhVuc + ", chuongSach: " + chuongSachs + "\n";
	}

	@Override
	public String layLoaiAnPham() {
		return "Sach tham khao";
	}

	@Override
	public boolean tapChiCungTen(String name) {
		return false;
	}

	@Override
	public boolean kiemTraTapChi() {
		return false;
	}

	public int laySoTrangLonNhat() {
		int max = 0;
		for (ChuongSach cs : chuongSachs) {
			if (cs.getSoTrangC() > max)
				max = cs.getSoTrangC();
		}
		return max;
	}
}
