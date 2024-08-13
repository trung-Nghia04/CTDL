package task_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> chuongSachs = new ArrayList<>();

	public SachThamKhao(String tieuDe, String soTrang, int namXB, String tacGia, int giaTien, String linhVuc) {
		super(tieuDe, soTrang, namXB, tacGia, giaTien);
		this.linhVuc = linhVuc;
	}

	@Override
	public String layTenAnPham() {
		return "Sach tham khao";
	}

	public ChuongSach chuongSachNhieuTrangNhat() {
		return chuongSachs.stream().max(Comparator.comparing(ChuongSach::getSoTrang)).get();
	}

	@Override
	public boolean tapChiCungTen(String name) {
		return false;
	}

	public void themChuongSach(ChuongSach c1) {
		this.chuongSachs.add(c1);
	}
	@Override
	public String toString() {
		return "AnPham: " + tieuDe + ", soTrang: " + soTrang + ", namXB: " + namXB + ", tacGia: " + tacGia
				+ ", giaTien: " + giaTien + " SachThamKhao: \n" + linhVuc + ", chuongSach: " + chuongSachs + "\n";
	}

}
