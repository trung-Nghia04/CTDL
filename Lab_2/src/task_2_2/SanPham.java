package task_2_2;

public abstract class SanPham {
	protected String tenSP;
	protected String loai;
	protected int gia;

	public SanPham(String tenSP, String loai, int gia) {
		this.tenSP = tenSP;
		this.loai = loai;
		this.gia = gia;
	}

	public void tangGia() {
		this.gia = (int) (gia * 1.05);
	}

	public abstract boolean kiemTraNguonGoc();

	public boolean kiemTraSPTrongNuoc(int x) {
		return !kiemTraNguonGoc() && this.gia > x;
	}
	
	public boolean cungTen(SanPham that) {
		return this.tenSP.equals(that.tenSP);
	}

	public String getTenSP() {
		return tenSP;
	}

	public int getGia() {
		return gia;
	}

	@Override
	public String toString() {
		return "SanPham: " + tenSP + "loai: " + loai + ", gia: " + gia;
	}

}
