package task_2_1;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		NhanVien nv1 = new NhanVien("001", "DTN", new Date(2000, 11, 01), 10);
		NhanVien nv2 = new NhanVien("002", "DTN", new Date(2001, 11, 10), 8);
		NhanVien nv3 = new NhanVien("003", "DTN", new Date(2002, 01, 02), 5);
		NhanVien nv4 = new NhanVien("004", "DTN", new Date(2000, 04, 01), 20);
		NhanVien nv5 = new NhanVien("005", "DTN", new Date(2003, 03, 16), 6);
		NhanVien nv6 = new NhanVien("006", "DTN", new Date(2004, 07, 01), 7);

		PhongBan pb1 = new PhongBan("IT", nv1);
		pb1.themNhanVien(nv1);
		pb1.themNhanVien(nv2);
		pb1.themNhanVien(nv3);
		PhongBan pb2 = new PhongBan("Thiet Ke", nv6);
		pb2.themNhanVien(nv4);
		pb2.themNhanVien(nv5);
		pb2.themNhanVien(nv6);

		CongTy ct = new CongTy("Cong nghe");
		ct.themPB(pb1);
		ct.themPB(pb2);

//		System.out.println(ct);
//		System.out.println("-------------------------------");
		System.out.println("Danh sách các nhân viên của phòng ban IT được khen thưởng: \n" + pb1.dsNVKhenThuong());
		System.out.println("-------------------------------");
		System.out
				.println("Danh sách các nhân viên của phòng ban thiet ke được khen thưởng: \n" + pb2.dsNVKhenThuong());
		System.out.println("-------------------------------");
		System.out.println("nhân viên có kpi tháng hiện tại cao nhất phòng ban IT: " + pb1.nvUuTu());
		System.out.println("-------------------------------");
		System.out.println("nhân viên có kpi tháng hiện tại cao nhất phòng ban thiet ke: " + pb2.nvUuTu());
		System.out.println("-------------------------------");
		System.out.println("nhân viên có kpi tháng hiện tại cao nhất công ty: " + ct.nvXS());

	}
}
