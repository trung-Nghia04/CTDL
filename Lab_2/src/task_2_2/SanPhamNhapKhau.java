package task_2_2;

public class SanPhamNhapKhau extends SanPham {
	private String nuocNhapKhau;

	public SanPhamNhapKhau(String tenSP, String loai, int gia, String nuocNhapKhau) {
		super(tenSP, loai, gia);
		this.nuocNhapKhau = nuocNhapKhau;
	}

	
	@Override
	public String toString() {
		return "SanPhamNhapKhau: " + nuocNhapKhau + ", tenSP: " + tenSP + ", loai: " + loai + ", gia: " + gia + "\n";
	}


	@Override
	public boolean kiemTraNguonGoc() {
		// TODO Auto-generated method stub
		return true;
	}

}
