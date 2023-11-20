package task_2;

public class TapChi extends AnPham {
	private String ten;

	public TapChi(String tieuDe, int soTrang, int namXuarBan, String tacGia, int gia, String ten) {
		super(tieuDe, soTrang, namXuarBan, tacGia, gia);
		this.ten = ten;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getType() {
		return "tạp chí";
	}
}
