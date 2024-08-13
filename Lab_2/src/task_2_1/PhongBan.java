package task_2_1;

import java.util.ArrayList;
import java.util.List;

public class PhongBan {
	private String namePB;
	private NhanVien truongPhong;
	private List<NhanVien> dsNV = new ArrayList<>();

	public PhongBan(String namePB, NhanVien truongPhong) {
		this.namePB = namePB;
		this.truongPhong = truongPhong;
	}

	public void themNhanVien(NhanVien nv) {
		this.dsNV.add(nv);
	}

//	Phương thức lấy ra ra danh sách các nhân viên của phòng ban được khen
	public ArrayList<NhanVien> dsNVKhenThuong() {
		ArrayList<NhanVien> re = new ArrayList<>();
		for (NhanVien nv : dsNV) {
			if (nv.kpi7())
				re.add(nv);
		}
		return re;
	}

	// Phương thức tìm ra về nhân viên có kpi tháng hiện tại cao nhất phòng ban.
	public NhanVien nvUuTu() {
		NhanVien re = dsNV.get(0);
		for (NhanVien nv : dsNV) {
			if (nv.sosanhKPI(re))
				re = nv;
		}
		return re;
	}

	@Override
	public String toString() {
		return "Phong ban: " + namePB + ", truongPhong:" + truongPhong + "dsNV:" + "\n" + dsNV;
	}

}
