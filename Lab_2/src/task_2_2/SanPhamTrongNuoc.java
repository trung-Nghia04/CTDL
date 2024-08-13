package task_2_2;

public class SanPhamTrongNuoc extends SanPham {

	public SanPhamTrongNuoc(String tenSP, String loai, int gia) {
		super(tenSP, loai, gia);

	}

	

	@Override
	public String toString() {
		return "SanPhamTrongNuoc: " + tenSP + ", loai: " + loai + ", gia: " + gia;
	}



	@Override
	public boolean kiemTraNguonGoc() {
		// TODO Auto-generated method stub
		return false;
	}

}
