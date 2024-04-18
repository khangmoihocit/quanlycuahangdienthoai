package quanly;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import quanlifile.QuanLyFile;

public class QuanLyHoaDon {
	private ArrayList<HoaDon> dsHoaDon;
	private QuanLyFile quanLyFile;

	public QuanLyHoaDon(){
		dsHoaDon = new ArrayList<HoaDon>();
		quanLyFile = new QuanLyFile();
	}

	//them hoa don vo danh sach
	public void themHD(HoaDon hd){
		dsHoaDon.add(hd);
	}
	//hien thi danh sach hoa don
	public void hienHD(){
		String fomat = "%-15s %-20s %-30s";
		System.out.println(String .format(fomat, "Mã hóa đơn","Tên khách hàng",
		  "Ngày tạo"));
		for (HoaDon hd : dsHoaDon){
			System.out.println(String.format(fomat, hd.getMaHD(), hd.getKhachHang().getTen(), hd.getNgayTaoHD()));
		}
	}
	//hien thi chi tiet hoa don
	public void hienThiChiTietHD(String maHD){
		HoaDon x  = timHoaDon(maHD);
		if (x != null){
			System.out.println(x);
		}
		else System.out.println("Hóa đơn không tồn tại. Vui lòng thử lại!");
	}
	//tim hoa don theo maHD
	public HoaDon timHoaDon(String maHD){
		for (HoaDon x : dsHoaDon){
			if (x.getMaHD().equalsIgnoreCase(maHD))
				return x;
		}
		return null;
	}

	public String thoiGianTaoHD(String s){
		String res = "";
		for (int i =0; i< s.length() - 9; ++i){
			res+=s.charAt(i);
		}
		return res;
	}
	//loc hoa don theo ngay
	public void locHoaDonTheoNgay(){
		Scanner sc = new Scanner(System.in);
		//kiem tra du lieu nguoi nhap
		Pattern pattern = Pattern.compile("^[0-9]{2}-[0-9]{2}-[0-9]{4}$");
		while(true){
			System.out.print("Nhập thời gian(dd-mm-yyyy): ");
			String txt = sc.nextLine();
			if (pattern.matcher(txt).find()){
				String fomat = "%-15s %-20s %-30s";
				System.out.println(String .format(fomat, "Mã hóa đơn","Tên khách hàng","Ngày tạo"));
				for (HoaDon hd : dsHoaDon){
					if (thoiGianTaoHD(hd.getNgayTaoHD()).equalsIgnoreCase(txt)){
						System.out.println(String.format(fomat, hd.getMaHD(), hd.getKhachHang().getTen(), hd.getNgayTaoHD()));
					}
				}
				break;
			}
			else{
				System.out.println("Vui lòng nhập thời gian tìm kiếm theo định dạng: dd-mm-yyyy.");
			}
		}
	}
	//xuat hoa don ra file
	public void xuatHoaDon(String maHD){
		HoaDon hd = timHoaDon(maHD);
		if (hd != null){
			quanLyFile.xuatHD(hd.toString());
			System.out.println("Xuất hóa đơn thành công ra file thongtinhoadon.txt!");
		}
		else System.out.println("Hóa đơn không tồn tại. Vui lòng thử lại!");
	}
}