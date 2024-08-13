package task_2;

public class ChuongSach {
	private String tieuDeCH;
	private int soTrang;

	public ChuongSach(String tieuDeCH, int soTrang) {
		this.tieuDeCH = tieuDeCH;
		this.soTrang = soTrang;
	}

	public int getSoTrang() {
		return soTrang;
	}

	@Override
	public String toString() {
		return tieuDeCH + ", soTrangC: " + soTrang + ", ";
	}
}
