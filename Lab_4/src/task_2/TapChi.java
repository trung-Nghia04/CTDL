package task_2;

public class TapChi extends AnPham {
	private String tenTapChi;

	public TapChi(String tieuDe, int soTrang, int namXB, String tacGia, double giaTien, String tenTapChi) {
		super(tieuDe, soTrang, namXB, tacGia, giaTien);
		this.tenTapChi = tenTapChi;
	}

	@Override
	public String layLoaiAnPham() {
		return "Tap chi";
	}

	@Override
	public boolean tapChiCungTen(String name) {
		return this.tenTapChi.equals(name);
	}

	@Override
	public boolean kiemTraTapChi() {
		return (2021 - this.namXB) >= 10;
	}

	@Override
	public String toString() {
		return "AnPham: " + tieuDe + ", soTrang: " + soTrang + ", namXB: " + namXB + ", tacGia: " + tacGia
				+ ", giaTien: " + giaTien + " TapChi: " + tenTapChi + "\n";
	}
}
