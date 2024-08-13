package task_2;

public abstract class AnPham {
	protected String tieuDe;
	protected int soTrang, namXB;
	protected String tacGia;
	protected double giaTien;

	public AnPham(String tieuDe, int soTrang, int namXB, String tacGia, double giaTien) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXB = namXB;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}

	public abstract String layLoaiAnPham();

	public abstract boolean kiemTraTapChi();

	public double getGiaTien() {
		return giaTien;
	}

	public int getNamXB() {
		return namXB;
	}

	public String getTacGia() {
		return tacGia;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public abstract boolean tapChiCungTen(String name);

	public boolean sachTren500Trang() {
		return this.soTrang > 500;
	}



}
