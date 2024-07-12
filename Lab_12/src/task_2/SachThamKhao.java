package task_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> chuongSach = new ArrayList<>();

	public SachThamKhao(String tieuDe, int songTrang, int namXuatBan, String tacGia, int gia, String linhVuc,
			List<ChuongSach> chuongSach) {
		super(tieuDe, songTrang, namXuatBan, tacGia, gia);
		this.linhVuc = linhVuc;
		this.chuongSach = chuongSach;
	}

	public void add(ChuongSach c) {
		this.chuongSach.add(c);
	}

	public List<ChuongSach> getChuongSach() {
		return chuongSach;
	}

	public ChuongSach getMaxChuongSach() {
		return chuongSach.stream().max(Comparator.comparing(ChuongSach::getSoTrang)).get();
	}

	public long tongSoTrang() {
		return chuongSach.stream().collect(Collectors.summarizingLong(ChuongSach::getSoTrang)).getSum();
	}

	@Override
	public String loaiAnPham() {

		return tieuDe + " " + songTrang + " " + namXuatBan + " " + tacGia + " " + gia + " " + linhVuc + " "
				+ chuongSach;
	}

	@Override
	public boolean laTapChiXuatBan10Nam(int namHienTai) {
		return false;
	}

}
