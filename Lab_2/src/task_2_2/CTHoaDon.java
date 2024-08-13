package task_2_2;

public class CTHoaDon {
	private SanPham thongTinSanPham;
	private int soLuongMua;

	public CTHoaDon(SanPham thongTinSanPham, int soLuongMua) {
		this.thongTinSanPham = thongTinSanPham;
		this.soLuongMua = soLuongMua;
	}

	public int cost() {
		return this.thongTinSanPham.getGia() * soLuongMua;
	}

	public boolean soLuongBanNhieuHon(CTHoaDon that) {
		return this.soLuongMua > that.soLuongMua;
	}

	public SanPham getThongTinSanPham() {
		return thongTinSanPham;
	}

	public boolean cungTen(SanPham that) {
		return thongTinSanPham.cungTen(that);
	}

	public boolean laNhapKhau() {
		return thongTinSanPham.kiemTraNguonGoc();
	}

	public int getSoLuongMua() {
		return soLuongMua;
	}

	@Override
	public String toString() {
		return "CTHoaDon:\n " + thongTinSanPham + ", soLuongMua: " + soLuongMua + "\n";
	}
}
