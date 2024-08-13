package task_2_1;

import java.util.Date;

public class NhanVien {
	private String code, hVTen;
	private Date ngaySinh;
	private double kPI;

	public NhanVien(String code, String hVTen, Date ngaySinh, double kPI) {
		super();
		this.code = code;
		this.hVTen = hVTen;
		this.ngaySinh = ngaySinh;
		this.kPI = kPI;
	}

	public boolean kpi7() {
		return this.kPI >= 7;
	}

	public boolean sosanhKPI(NhanVien that) {
		return this.kPI > that.kPI;
	}
	

	public double getkPI() {
		return kPI;
	}

	@Override
	public String toString() {
		return "NhanVien: " + code + ", Ho ten: " + hVTen + ", ngay sinh: " + ngaySinh + ", KPI: " + kPI + "\n";
	}

}
