package task_2;

public abstract class AnPham {
	protected String tieuDe;
	protected int songTrang;
	protected int namXuatBan;
	protected String tacGia;
	protected int gia;

	public AnPham(String tieuDe, int songTrang, int namXuatBan, String tacGia, int gia) {
		this.tieuDe = tieuDe;
		this.songTrang = songTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.gia = gia;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public int getSongTrang() {
		return songTrang;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public int getGia() {
		return gia;
	}

	public abstract String loaiAnPham();

	public abstract boolean laTapChiXuatBan10Nam(int namHienTai);

	public boolean coCungLoaiCungtacGia(AnPham ap) {
		return this.loaiAnPham().equals(ap.loaiAnPham()) && this.tacGia.equals(ap.tacGia);
	}

}
