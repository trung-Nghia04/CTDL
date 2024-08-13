package task_2;

public abstract class AnPham {
	protected String tieuDe;
	protected String soTrang;
	protected String tacGia;
	protected int namXB;
	protected int giaTien;

	public AnPham(String tieuDe, String soTrang, int namXB, String tacGia, int giaTien) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXB = namXB;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}

	// trả về loại Ấn phẩm
	public abstract String layTenAnPham();

//	 kiểm tra xem ấn phẩm là tạp chí và có thời gian xuất bản cách đây (2021) 10 năm hay không
	public boolean kiemTraTapChi() {
		return this.layTenAnPham().equals("Tap chi") && (this.namXB - 2021) == 10;
	}

	public boolean cungTacGia(AnPham that) {
		return this.tacGia.equals(that.tacGia);
	}

	public int getGiaTien() {
		return giaTien;
	}

	public int getNamXB() {
		return namXB;
	}

	public abstract boolean tapChiCungTen(String name);

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

}
