package task_2;

public class TapChi extends AnPham {
	private String tenTapChi;

	public TapChi(String tieuDe, int songTrang, int namXuatBan, String tacGia, int gia, String tenTapChi) {
		super(tieuDe, songTrang, namXuatBan, tacGia, gia);
		this.tenTapChi = tenTapChi;
	}

	public String getTenTapChi() {
		return tenTapChi;
	}

	public void setTenTapChi(String tenTapChi) {
		this.tenTapChi = tenTapChi;
	}

	@Override
	public String loaiAnPham() {
		return tenTapChi;
	}

	@Override
	public boolean laTapChiXuatBan10Nam(int namHienTai) {
		return (namHienTai - this.namXuatBan) == 10;
	}

	@Override
	public String toString() {
		return tieuDe + " " + songTrang + " " + namXuatBan + " " + tacGia + " " + gia + " " + tenTapChi;
	}

}
