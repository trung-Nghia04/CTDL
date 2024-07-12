package task_2;

public class ChuongSach {
	private String tieuDe;
	private int soTrang;

	public ChuongSach(String tieuDe, int sotTrang) {
		super();
		this.tieuDe = tieuDe;
		this.soTrang = sotTrang;
	}

	
	public int getSoTrang() {
		return soTrang;
	}
	@Override
	public String toString() {
		return "tieuDe: " + tieuDe + ", sotTrang: " + soTrang;
	}
	

}
