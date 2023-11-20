package task_2;

import java.util.ArrayList;
import java.util.List;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> dsChuonhg;

	public SachThamKhao(String tieuDe, int soTrang, int namXuarBan, String tacGia, int gia, String linhVuc) {
		super(tieuDe, soTrang, namXuarBan, tacGia, gia);
		this.linhVuc = linhVuc;
		this.dsChuonhg = new ArrayList<>();
	}

	public String getLinhVuc() {
		return linhVuc;
	}

	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
	}

	public List<ChuongSach> getDsChuonhg() {
		return dsChuonhg;
	}

	public void setDsChuonhg(List<ChuongSach> dsChuonhg) {
		this.dsChuonhg = dsChuonhg;
	}

	public String toString() {
		return "SachKhamKhao [linhVuc=" + linhVuc + ", chuongSach=" + dsChuonhg + ", tieuDe=" + tieuDe + ", soTrang="
				+ soTrang + ", namXuatBan=" + namXuatBan + ", tacGia=" + tacGia + ", giaTien=" + gia + "]";
	}
	public void themChuong(ChuongSach chuong) {
		dsChuonhg.add(chuong);
		
	}

	public String getType() {
		return "sách tham khảo";
	}
}
