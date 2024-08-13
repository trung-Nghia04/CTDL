package task_2_1;

import java.util.ArrayList;
import java.util.List;

public class CongTy {
	private String nameCT;
	private List<PhongBan> dsPhongBan = new ArrayList<>();

	public CongTy(String nameCT) {
		this.nameCT = nameCT;
	}

	public void themPB(PhongBan pb) {
		this.dsPhongBan.add(pb);
	}

	// Phương thức tìm ra về nhân viên có kpi tháng hiện tại cao nhất công ty.
	public NhanVien nvXS() {
		NhanVien re = null;
		double max = 0;
		for (PhongBan pb : dsPhongBan) {
			if (pb.nvUuTu().getkPI() > max) {
				max = pb.nvUuTu().getkPI();
				re = pb.nvUuTu();
			}
		}
		return re;
	}

	@Override
	public String toString() {
		return "Ten cong ty: " + nameCT + " \n" + "dsPhongBan: \n" + dsPhongBan;
	}

}
