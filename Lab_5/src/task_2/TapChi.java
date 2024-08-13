package task_2;

public class TapChi extends AnPham {
	private String tenTapChi;

	public TapChi(String tieuDe, String soTrang, int namXB, String tacGia, int giaTien, String tenTapChi) {
		super(tieuDe, soTrang, namXB, tacGia, giaTien);
		this.tenTapChi = tenTapChi;
	}

	@Override
	public String layTenAnPham() {
		return "Tap chi";
	}

	@Override
	public boolean tapChiCungTen(String name) {
		return this.tenTapChi.equals(name);
	}

	public String getTenTapChi() {
		return tenTapChi;
	}

	@Override
	public String toString() {
		return "AnPham: " + tieuDe + ", soTrang: " + soTrang + ", namXB: " + namXB + ", tacGia: " + tacGia
				+ ", giaTien: " + giaTien + " TapChi: " + tenTapChi + "\n";
	}

}
