package task_2;

public class ChuongSach {
	private String tieuDeC;
	private int soTrangC;

	public ChuongSach(String tieuDeC, int soTrangC) {
		this.tieuDeC = tieuDeC;
		this.soTrangC = soTrangC;
	}

	@Override
	public String toString() {
		return tieuDeC + ", soTrangC: " + soTrangC+", ";
	}

	public int getSoTrangC() {
		return soTrangC;
	}

}
