package main;

import java.util.Scanner;

import quanly.HoaDon;
import quanly.QuanLyHoaDon;
import quanly.QuanLyKhachHang;
import quanly.QuanLyKho;
import quanly.QuanLyNhanVien;
import quanly.QuanLySanPham;
import quanly.SanPham;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void menuKhachHang() {
		System.out.println("-------MENU------");
		System.out.println("1. Thêm khách hàng \n" 
				+ "2. Hiện danh sách khách hàng \n" 
				+ "3. đọc dữ liệu từ file\n"
				+ "4. ghi dữ liệu vô file\n" 
				+ "5. Xóa khách hàng\n"
				+ "6. Cập nhật thông tin khách hàng\n" 
				+ "7. Sắp xếp theo tên khách hàng\n"
				+ "8. Kết thúc chương trình\n"
				+ "0. Quay lại menu chính");

	}
	public static void khachHang(QuanLyKhachHang qlkh,int chon) {
		switch (chon) {
		case 0:{
			System.out.println("---"); break;
		}
		case 1: {
			qlkh.inputKH();break;
		}
		case 2:{
			System.out.println("danh sách khách hàng: ");
			qlkh.hienKH();break;
		}
		case 4:{
			qlkh.ghiFile(); 
			System.out.println("Ghi thành công vào file thongtinkhachhang.txt!");
			break;
		}
		case 3:{
			qlkh.docFile();
			System.out.println("đọc file thành công!");
			break;
		}
		
		case 5:{
			sc.nextLine();
			System.out.print("Nhập ID khách hàng muốn xóa: "); 
			String id = sc.nextLine();
			qlkh.xoaKH(id); break;
		}
		case 6:{
			sc.nextLine();
			System.out.print("Nhập ID khách hàng muốn cập nhập: "); 
			String id = sc.nextLine();
			qlkh.capNhapKH(id); break;
		}
		case 7:{
			qlkh.sapXepTheoTen();
			qlkh.hienKH(); break;
		}
		case 8:{
			System.out.println("đã thoát chương trình!");break;
		}
		default:{
			System.err.println("Lỗi! Vui lòng nhập theo menu."); break;
		}
		}
	}
	
	public static void menuNhanVien() {
		System.out.println("-------------------------------MENU------------------------------");
		System.out.println("1. Thêm nhân viên");
		System.out.println("2. Hiện nhân viên");
		System.out.println("3. Tìm nhân viên");
		System.out.println("4. Xóa nhân viên");
		System.out.println("5. Thống kê lương nhân viên");
		System.out.println("6. Đọc file");
		System.out.println("7. Ghi file");
		System.out.println("8. Kết thúc chương trình");
		System.out.print("0. Quay lại menu chính");
	}
	public static void nhanVien(QuanLyNhanVien qlnv, int chon){
			switch(chon) {
			case 0:{
				System.out.println("---"); break;
			}	
			case 1:{
				if (!qlnv.themNhanVien()){
					System.out.println("ID nhân viên đã tồn tại");break;
				}
				break;
			}
			case 2:{
				qlnv.hienDSNhanVien();
				break;
			}
			case 3:{
				System.out.println("Nhập id nhân viên cần tìm: ");
				String idtim = sc.nextLine();
				if(qlnv.timNhanVien(idtim)==null) 
					System.out.println("Không tìm thấy nhân viên có id: "+idtim);
				else 
					System.out.println(qlnv.timNhanVien(idtim).toString());
				break;
			}
			case 4:{
				System.out.println("Nhập id nhân viên cần xóa: ");
				String idxoa = sc.nextLine();
				if(qlnv.XoaNhanVien(idxoa)==true) {
					System.out.println("Xóa thành công");
				}else {
					System.out.println("Xóa thất bại");
				}
				break;
			}
			case 5:{
				System.out.println("Thống kê lương nhân viên: ");
				qlnv.thongKeLuong();
				break;
			}
			case 6:{
				qlnv.docFileNhanVien();
				System.out.println("Đọc file thành công!");
				break;
			}
			case 7:{
				qlnv.ghiFileNhanVien();
				System.out.println("Ghi thành công vào file thongtinnhanvien.txt!");
				break;
			}
			case 8:{
				System.out.println("Đã thoát chương trình!");
				break;
			}
			default:{
				System.out.println("Lỗi! Vui lòng chọn theo menu");
				break;
			}
			}
		}

	public static void menuSanPham() {
		System.out.println("-------------------------------MENU------------------------------");
		System.out.println("1. Đọc dữ liệu từ file\n"
				+ "2. Hiện danh sách sản phẩm\n"
				+ "3. Thêm sản phẩm mới\n"
				+ "4. Tìm sản phẩm\n"
				+ "5. Cập nhật thông tin sản phẩm\n"
				+ "6. Sắp xếp theo giá từ cao --> thấp\n"
				+ "7. Sắp xếp theo giá từ thấp --> cao \n"
				+ "8. Ghi dữ liệu vô file\n"
				+ "9. Xóa sản phẩm\n"
				+ "10. Cập nhật số lượng sản phẩm\n"
				+ "11. Kết thúc chương trình\n"
				+ "0. Quay lại menu chính.");
	}
	public static void sanPham(QuanLySanPham qlsp, int chon) {
		switch(chon) {
		case 1:{
			qlsp.docFile();
			System.out.println("Đọc file thành công!");
			break;
		}
		case 2: {
			qlsp.hienSP();
			break;
		}
		case 3: {
			qlsp.nhapSP();break;
		}
		case 4: {
			sc.nextLine();
			System.out.print("Nhập mã sản phẩm muốn tìm: ");
			String masp = sc.nextLine();
			SanPham sp = qlsp.timKiemSP(masp);
			if (sp != null){
				String format = "%-5s %-25s %-5s %-15s %-15s %-15s %-28s %-10s %-15s %-15s";
				String tieuDe = String.format(format, "Mã SP", "Tên SP", "SL", "thương hiệu", "hệ điều hành", 
				"kích thước màn", "chip xử lý", "pin", "Xuất xứ", "giá(VND)");
				System.out.println(tieuDe);
				System.out.println(sp);
			}
			else System.out.println("Mã sản phẩm không tồn tại!");
			break;
		}
		case 5:{
			sc.nextLine();
			System.out.println("--------Cập nhật sản phẩm------");
			System.out.print("Nhập mã sản phẩm muốn cập nhật: ");
			String masp = sc.nextLine();
			qlsp.capNhatSP(masp);
		
			break;
		}
		case 6:{
			qlsp.sapXepTheoGiaGiam();
			System.out.println("Danh sách sản phẩm sau khi sắp xếp là: ");
			qlsp.hienSP(); break;
		}
		case 7: {
			qlsp.sapXepTheoGiaTang();
			System.out.println("Danh sách sản phẩm sau khi sắp xếp là: ");
			qlsp.hienSP(); break;
		}
		case 8:{
			qlsp.ghiFile(); System.out.println("Ghi thành công vào file thongtinsanpham.txt!");
			break;
		}
		case 9:{
			sc.nextLine();
			System.out.print("Nhập mã sản phẩm muốn xóa: ");
			String masp = sc.nextLine();
			qlsp.xoa(masp); break;
		}
		case 10:{
			sc.nextLine();
			System.out.print("Nhập mã sản phẩm muốn cập nhật số lượng: ");
			String masp = sc.nextLine();
			SanPham sp = qlsp.timKiemSP(masp);
			if (sp != null){
				System.out.print("Nhập số lượng mới: ");
				int sl = sc.nextInt();
				sp.setSoLuong(String.valueOf(sl));
				System.out.println("Cập nhật số lượng thành công!");
			}
			else System.out.println("Mã sản phẩm không tồn tại!");
			break;
		}
		case 11:{
			System.out.println("Đã thoát chương trình"); break;
		}
		case 0:{
			System.out.println("---"); break;
		}
		default:{
			System.err.println("lỗi! Vui lòng chọn theo menu"); break;
		}
		}
	}
	
	public static void menuHoaDon() {
		System.out.println("-------------------------------MENU------------------------------");
		System.out.println("1. Khởi tạo hóa đơn.\n"
				+ "2. Hiện thị danh sách hóa đơn.\n"
				+ "3. Xuất hóa đơn ra file.\n"
				+ "4. Lọc hóa đơn theo thời gian.\n"
				+ "5. Hiện thị chi tiết hóa đơn.\n"
				+ "6. Kết thúc chương trình.\n"
				+ "0. quay lại menu chính.");
	}
	public static void hoaDon(QuanLyHoaDon qlhd, QuanLyKhachHang qlkh, QuanLySanPham qlsp, int chon) {
		switch(chon) {
		case 0:{
			System.out.println("---"); break;
		}
		case 1: {
			HoaDon hd = new HoaDon();
			hd.khoiTaoHoaDon(qlsp, qlkh);
			qlhd.themHD(hd);
			break;
		}
		case 2:{
			qlhd.hienHD();
			break;
		}
		case 3:{
			sc.nextLine();
			System.out.print("Nhập mã hóa đơn muốn xuất ra file: ");
			String maHD = sc.nextLine();
			qlhd.xuatHoaDon(maHD);
			break;
		}
		case 4:{
			qlhd.locHoaDonTheoNgay();
			break;
		}
		case 5:{
			sc.nextLine();
			System.out.print("Nhập mã hóa đơn: ");
			String maHD = sc.nextLine();
			qlhd.hienThiChiTietHD(maHD);
			break;
		}
		case 6:{
			System.out.println("đã thoát chương trình!"); break;
		}
		default:{
			System.err.println("Lỗi! Vui lòng nhập theo menu"); break;
		}
		}
	}
	
	public static void menuKho() {
		System.out.println("-------------------------------MENU------------------------------");
		System.out.println("1. Nhập kho.\n"
				+ "2. Hiện thị danh sách kho.\n"
				+ "3. Hiện thị chi tiết kho.\n"
				+ "4. Lưu kho(quanlykho.txt).\n"
				+ "5. Đọc file.\n"
				+ "6. Cập nhật kho.\n"
				+ "7. Kết thúc chương trình.\n"
				+ "0. Quay lại menu chính.");
	}
	public static void kho(QuanLyKho qlk,QuanLySanPham qlsp ,int chon) {
		switch(chon){
			case 0:{
				System.out.println("---"); break;
			}
			case 1:{
				qlk.nhapKho();
				break;
			}
			case 2:{
				qlk.hienThiDanhSachKho();
				break;
			}
			case 3:{
				sc.nextLine();
				System.out.print("Nhập mã kho muốn xem: ");
				String maKho = sc.nextLine();
				qlk.hienThiChiTietKho(maKho, qlsp);
				break;
			}
			case 4:{
				qlk.ghiFile();
				System.out.println("Ghi thành công vào file quanlykho.txt!");
				break;
			}
			case 5:{
				qlk.docFile();
				System.out.println("Đọc file thành công!");
				break;
			}
			case 6:{
				sc.nextLine();
				System.out.print("Nhập mã kho muốn cập nhật: ");
				String maKho = sc.nextLine();
				qlk.capNhatKho(maKho);
				break;
			}
			case 7:{
				System.out.println("Đã thoát chương trình!");
				break;
			}
			default:{
				System.err.println("Lỗi! Vui lòng nhập theo menu");
				break;
			}
		}
	}
	//main
	public static void main(String[] args) {
		QuanLyKhachHang qlkh = new QuanLyKhachHang();
		QuanLyNhanVien qlnv = new QuanLyNhanVien();
		QuanLySanPham qlsp = new QuanLySanPham();
		QuanLyHoaDon qlhd = new QuanLyHoaDon();
		QuanLyKho qlk = new QuanLyKho();
		int chon = 0, chon1 = 0, chon2 = 0, chon3 =0, chon4= 0, chon5 = 0;
		do {
			if (chon1 == 0 && chon2 == 0 && chon3 == 0 && chon4 == 0 && chon5 == 0) {
				System.out.println("1. Quản lý khách hàng.\n"
						+ "2. Quản lý nhân viên.\n"
						+ "3. Quản lý sản phẩm.\n"
						+ "4. Quản lý hóa đơn.\n"
						+ "5. Quản lý kho.");
				System.out.print("chọn: ");
				chon = sc.nextInt();
			}
			//quản lý khách hàng
			if(chon == 1) {
				menuKhachHang(); System.out.print("chọn: "); chon1 = sc.nextInt();
				khachHang(qlkh, chon1);
			}
			//quản lý nhân viên
			else if (chon == 2) {	
				menuNhanVien(); System.out.println("chọn: "); chon2 = sc.nextInt();
				nhanVien(qlnv, chon2);
			}
			//quản lý sản phẩm
			else if(chon == 3) {
				menuSanPham(); System.out.print("chọn: "); chon3 = sc.nextInt();
				sanPham(qlsp, chon3);
			}
			//quan ly hoa don
			else if (chon == 4) {
				menuHoaDon(); System.out.print("chọn: "); chon4 = sc.nextInt();
				hoaDon(qlhd, qlkh, qlsp, chon4);
			}
			//quan ly kho
			else if (chon == 5){
				menuKho(); System.out.print("chọn: "); chon5 = sc.nextInt();
				kho(qlk, qlsp, chon5);
			}
			else {
				System.err.println("coming sôn");
			}
		} while (chon1 != 8 || chon2 !=8  || chon3 != 11 || chon4 != 6 || chon5 != 7);
	}
}
