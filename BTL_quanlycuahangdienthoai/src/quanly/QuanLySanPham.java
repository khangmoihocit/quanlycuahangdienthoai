package quanly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import quanlifile.QuanLyFile;

public class QuanLySanPham {
	private ArrayList<SanPham> dsSanPham;
	private QuanLyFile qLFile;
	public QuanLySanPham() {
		this.dsSanPham = new ArrayList<SanPham>();
		this.qLFile = new QuanLyFile();
	}
	
	public ArrayList<SanPham> getDsSanPham() {
		return dsSanPham;
	}
	public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
		this.dsSanPham = dsSanPham;
	}

	public void themSP(SanPham x) {
		dsSanPham.add(x);
	}
	public void nhapSP() {
		SanPham x = new SanPham();
		x.input();
		dsSanPham.add(x);
	}
	public void hienSP() {
		String format = "%-5s %-25s %-5s %-15s %-15s %-15s %-28s %-10s %-15s %-15s";
		String tieuDe = String.format(format, "Mã SP", "Tên SP", "SL", "thương hiệu", "hệ điều hành", 
		"kích thước màn", "chip xử lý", "pin", "Xuất xứ", "giá(VND)");
		System.out.println(tieuDe);
		for (SanPham x : dsSanPham) {
			System.out.println(x);
		}
	}
	public void ghiFile() {
		qLFile.outputSP(dsSanPham);
	}
	
	public void docFile() {
		qLFile.inputSP(dsSanPham);
	}
	
	public void sapXepTheoMaSP() {
		Collections.sort(dsSanPham, new Comparator<SanPham>() {

			@Override
			public int compare(SanPham o1, SanPham o2) {
				int msp1 = Integer.parseInt(o1.getMaSP());
				int msp2 = Integer.parseInt(o2.getMaSP());
				return msp1 - msp2;
			}
		});
	}
	
	public SanPham timKiemSP(String maSP) { //binary_Search
		sapXepTheoMaSP();
		int msp = Integer.parseInt(maSP);
		int l = 0, r = dsSanPham.size() - 1;
		while (l <= r) {
			int mid = (l+r)/2;
			int spMid = Integer.parseInt(dsSanPham.get(mid).getMaSP());
			if (spMid == msp) {
				return dsSanPham.get(mid);
			}
			else if (spMid < msp) {
				l = mid+1;
			}
			else {
				r = mid-1;
			}
		}
		return null;
	}
	
	public void capNhatSP(String maSP) {
		SanPham x = timKiemSP(maSP);
		if (x != null) {
			x.input();
		}
		else {
			System.out.println("mã sản phẩm không tồn tại!");
		}
		
	}
	
	public void sapXepTheoGiaTang() {
		Collections.sort(dsSanPham, new Comparator<SanPham>() {
			@Override
			public int compare(SanPham o1, SanPham o2) {
				double a = Double.parseDouble(o1.chuanHoa(o1.getGiaString()));
				double b = Double.parseDouble(o2.chuanHoa(o2.getGiaString()));
				return (int) (a - b);
			}
		});
	}
	public void sapXepTheoGiaGiam() {
		Collections.sort(dsSanPham, new Comparator<SanPham>() {
			@Override
			public int compare(SanPham o1, SanPham o2) {
				double a = Double.parseDouble(o1.chuanHoa(o1.getGiaString()));
				double b = Double.parseDouble(o2.chuanHoa(o2.getGiaString()));
				return (int) (b - a);
			}
		});
	}
	public void xoa(String maSP) {
		SanPham x = timKiemSP(maSP);
		if (x != null) {
			dsSanPham.remove(x);
		}
		else {
			System.out.println("mã sản phẩm không tồn tại");
		}
	}
}
