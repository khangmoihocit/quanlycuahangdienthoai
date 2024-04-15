package quanly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import quanlifile.QuanLyFile;

public class QuanLyKhachHang {
	private ArrayList<KhachHang> dsKhachHang;
	private QuanLyFile qlFile;
	public QuanLyKhachHang() {
		dsKhachHang = new ArrayList<KhachHang>();
		qlFile = new QuanLyFile();
	}
	public QuanLyKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
		qlFile = new QuanLyFile();
	}
	public ArrayList<KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}
	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}
	
	// thêm khách hàng
	public void themKH(KhachHang x) {
		dsKhachHang.add(x);
	}
	//nhập thông tin khách hàng từ bàn phím
	public void inputKH() {
		KhachHang x = new KhachHang();
		x.nhap();
		dsKhachHang.add(x);
	}
	public void hienKH() {
		String foamString  = "%-10s %-20s %-10s %-25s %-15s %-20s";
		String tieuDe = String.format(foamString, "ID", "Họ và tên", "tuổi", "địa chỉ", "số điện thoại", "email");
		System.out.println(tieuDe + "\n-------------------------------------------------------------------------------------------------------------");
		for (KhachHang x : dsKhachHang) {
			System.out.println(x);
		}
	}
	public void docFile() {
		qlFile.inputKH(dsKhachHang);
	}
	public void ghiFile() {
		qlFile.outputKH(dsKhachHang);
	}
	public KhachHang timKH(String id) {
		for (KhachHang x : dsKhachHang) {
			if (x.getId().equals(id)) {
				return x;
			}
		}
		return null;
	}

	public void xoaKH(String id) {
		KhachHang x = timKH(id);
		if (x != null) {
			dsKhachHang.remove(x);
			System.out.println("xóa thành công");
		}
		else {
			System.out.println("id khách hàng không tồn tại!");
		}
	}
	public void capNhapKH(String id) {
		KhachHang x = timKH(id);
		if (x != null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("--------------Cập nhập thông tin khách hàng------------");
			System.out.print("Họ tên khách hàng: ");   x.setTen(sc.nextLine());
			System.out.print("Tuổi: "); x.setTuoi(sc.nextLine());
			System.out.print("Địa chỉ: "); x.setDiaChi(sc.nextLine());
			System.out.print("Số điện thoại: "); x.setSdt(sc.nextLine());
			System.out.print("Email: "); x.setEmail(sc.nextLine());
		}
		else {
			System.out.println("id khách hàng không tồn tại!");
		}
	}
	
	public void sapXepTheoTen() {
		Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				String[] a = o1.getTen().split("\\s+");
				String[] b = o2.getTen().split("\\s+");
				for (int i=a.length - 1; i>0; i--) {
					if (a[i].compareToIgnoreCase(b[i]) != 0) {
						return a[i].compareToIgnoreCase(b[i]);
					}	
				}
				return o1.getTen().compareToIgnoreCase(o1.getTen());
			}
		});
	}
}
