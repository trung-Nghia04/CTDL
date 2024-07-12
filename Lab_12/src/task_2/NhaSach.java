package task_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NhaSach {
	private List<AnPham> anPham = new ArrayList<>();

	public void add(AnPham ap) {
		this.anPham.add(ap);
	}

	public String toString() {
		return anPham.toString();
	}

	public long tongTien() {
		return anPham.stream().collect(Collectors.summarizingLong(AnPham::getGia)).getSum();
	}

	public AnPham sachTKNhieuTrangNhat() {
		Comparator<AnPham> comp = (ap1, ap2) -> {
			SachThamKhao tk1 = (SachThamKhao) ap1;
			SachThamKhao tk2 = (SachThamKhao) ap2;
			return Long.compare(tk1.getMaxChuongSach().getSoTrang(), tk2.getMaxChuongSach().getSoTrang());
		};
		return anPham.stream().filter(x -> x.loaiAnPham().equals("Sach Tham Khao")).max(comp).get();
	}

	public boolean coChuaTapChi(String tenTapChi) {
		return anPham.stream().filter(x -> x.loaiAnPham().equals("Tap Chi"))
				.filter(x -> ((TapChi) x).getTenTapChi().equals(tenTapChi)).count() != 0;
	}

	public List<AnPham> dsTapChi(int namXuatBan) {
		return anPham.stream().filter(x -> x.loaiAnPham().equals("Tap Chi"))
				.filter(x -> (x.getNamXuatBan() == namXuatBan)).toList();
	}

	public void sapXepTheoTieuDeVaNamXuatBan() {
		Comparator<AnPham> comp = Comparator.comparing(AnPham::getTieuDe).thenComparing(AnPham::getNamXuatBan,
				Comparator.reverseOrder());
		anPham.sort(comp);
	}

	public Map<Integer, Long> thongKeSoLuongAnPhamTheoNamXuatBan() {
		return anPham.stream().collect(Collectors.groupingBy(AnPham::getNamXuatBan, Collectors.counting()));
	}
}
