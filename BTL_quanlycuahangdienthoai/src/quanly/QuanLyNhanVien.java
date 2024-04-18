package quanly;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import quanlifile.QuanLyFile;

public class QuanLyNhanVien {
	List<NhanVien> dsNhanVien;
	QuanLyFile qlf = new QuanLyFile();
	public QuanLyNhanVien() {
		dsNhanVien = new Vector<NhanVien>();
		qlf = new QuanLyFile();
	}
	
	// Kiểm tra id nhân viên
	public boolean CheckIdNhanVien(String IdNhanVien) {
		Iterator<NhanVien> it = dsNhanVien.iterator();
		while(it.hasNext()) {
			NhanVien nhanvien = it.next();
			if(nhanvien.getId().equals(IdNhanVien)) {
				return true;
			}
		}
		return false;
	}
	// Thêm nhân viên 
	public boolean themNhanVien() {
		while(true) {
			NhanVien nhanvien = new NhanVien();
			nhanvien.nhap();
			if(CheckIdNhanVien(nhanvien.getId())==false) {
				dsNhanVien.add(nhanvien);
				return true;
			}
			return false;
		}
	}
	// Hiện danh sách nhân viên
	public void hienDSNhanVien() {
		String fomatString = "%-10s %-20s %-10s %-25s %-15s";
		System.out.println(String.format(fomatString, "ID", "Tên", "Tuổi", "Địa chỉ", "Lương"));
		for(NhanVien nhanvien : dsNhanVien) {
			System.out.println(nhanvien.toString());
		}
	}
	// Tìm nhân viên 
	public NhanVien timNhanVien(String IDnhanvien) {
		Iterator<NhanVien> it = dsNhanVien.iterator();
		while(it.hasNext()) {
			NhanVien nhanvien = it.next();
			if(nhanvien.getId().equals(IDnhanvien)) {
				return nhanvien;
			}
		}
		return null;
	}
	// Xóa nhân viên 
	public boolean XoaNhanVien(String IDnhanvien) {
		NhanVien nhanvien = timNhanVien(IDnhanvien);
		if(nhanvien != null) {
			System.out.println("Bạn có muốn xóa nhân viên "+nhanvien.getId()+ "? \n1-xóa, 2-không xóa");
			int chon = new Scanner(System.in).nextInt();
			if(chon==1) {
				dsNhanVien.remove(nhanvien);
				return true;
			}else {
				return false;
			}
		}else {
			System.out.println("Nhân viên không tồn tại");
		}
		return false;
	}
	
	// Thống kê tiền lương
	public void thongKeLuong() {
		// tạo bản sao ds nhân viên để sắp xếp 
		List<NhanVien> copyDSnhanvien = new Vector<>(dsNhanVien);
		//sắp xếp danh sách theo tiền lương giảm dần
		Collections.sort(copyDSnhanvien, new Comparator<NhanVien>() {
			public int compare(NhanVien nv1, NhanVien nv2) {
				return Double.compare(nv2.getLuong(), nv1.getLuong());
			}
		});
		// In danh sách nhân viên và tiền lương tương ứng
		System.out.println("Danh sách nhân viên theo thứ tự giảm dần của tiền lương:");
	    for (NhanVien nv : copyDSnhanvien) {
	        System.out.println("ID: " + nv.getId() + ", Tên: " + nv.getTen() + ", Lương: " + nv.getLuong());
	    }
	}
	
	//doc file
	public void docFileNhanVien() {
		qlf.inputNV(dsNhanVien);
	}
	//ghi file
	public void ghiFileNhanVien() {
		qlf.outputNV(dsNhanVien);
	}
}
