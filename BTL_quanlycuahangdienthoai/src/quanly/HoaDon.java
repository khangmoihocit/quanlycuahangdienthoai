package quanly;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import quanlifile.QuanLyFile;

public class HoaDon {
	private String maHD, ngayTaoHD;
	private KhachHang khachHang;
	private ArrayList<SanPham> dsSanPham;
	private QuanLyFile quanLyFile;
	static int soLuong;
	static int a = 0;
	// khởi tạo mã hoa don tự động tăng
	public static String maHD(String s, int a) {
		String res = "";
		if (a >= 0 && a < 10) {
			res = "00" + s;
		} else if (a >= 10 && a <= 99) {
			res = "0" + s;
		} else {
			res = s;
		}
		return res;
	}
	//khởi tạo thời gian tự động
	public static String time() {
		Date date = new Date(System.currentTimeMillis());
		DateFormat dfm = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return dfm.format(date);
	}
	public HoaDon(KhachHang khachHang) {
		a++;
		String s = String.valueOf(a);
		this.maHD = maHD(s, a);
		this.ngayTaoHD = time();
		this.khachHang = khachHang;
		this.dsSanPham = new ArrayList<SanPham>();
		this.quanLyFile = new QuanLyFile();
	}
	public HoaDon() {
		a++;
		String s = String.valueOf(a);
		this.maHD = maHD(s, a);
		this.ngayTaoHD = time();
		this.dsSanPham = new ArrayList<SanPham>();
		this.quanLyFile = new QuanLyFile();
	}
	
	
	// nhan vien nhap hoa don
	public void khoiTaoHoaDon(QuanLySanPham qlsp, QuanLyKhachHang qlkh) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Nhập mã khách hàng: "); String maKH = sc.nextLine();
			this.khachHang = qlkh.timKH(maKH);
			if (khachHang == null) {
				System.err.println("Khách hàng không tồn tại! Vui lòng nhập lại.\n");
			}
			else break;
		}
		System.out.print("nhập số lượng sản phẩm: ");
		int n = sc.nextInt(); sc.nextLine();
		int i = 1;
		//khi số lượng(n) sản phẩm bằng với với số lượng  đã đc thêm vào danh sách thì dừng
		while(dsSanPham.size() != n){	
			while(i <= n) {
				System.out.print("Nhập mã sản phẩm thứ " + i + " muốn mua: "); String maSP = sc.nextLine();
				System.out.print("Số lượng mua: "); soLuong = sc.nextInt();  sc.nextLine();
				SanPham x = qlsp.timKiemSP(maSP);
				if (x != null) {
					//cap nhat lai so luong san pham trong kho
					x.capNhatSoLuong(soLuong);
					qlsp.ghiFile();
					//thêm san pham vào danh sách
					this.dsSanPham.add(x);
					i++;
				}
				else{
					System.err.println("Sản phẩm không tồn tại! Vui lòng thử lại.");
				}
			}

		}
	}
	
	//lấy ra danh sách sản phẩm trong hóa đơn
	public String getdsSanPham() {
		String res = "";
		for (SanPham x : dsSanPham) {
			res += x.toStringHD() + "\n";
		}
		return res;
	}

	//tinh tong tien hoa don
	public Long getThanhTien() {
		long s = 0;
		for (SanPham x : dsSanPham) {
			s += Long.parseLong(x.chuanHoa(x.getGiaString())) * x.getSoLuongMua();
		}
		return s;
	}
	
	//xuat hoa don ra file
	public void xuatHD() {
		quanLyFile.xuatHD(toString());
	}
	
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getNgayTaoHD() {
		return ngayTaoHD;
	}
	public void setNgayTaoHD(String ngayTaoHD) {
		this.ngayTaoHD = ngayTaoHD;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public ArrayList<SanPham> getDsSanPham() {
		return dsSanPham;
	}
	public void setDsSanPham(ArrayList<SanPham> dsSanPham) {
		this.dsSanPham = dsSanPham;
	}
	@Override
	public String toString() {
		String format1 = "%-5s %-20s %-10s %-15s %-15s %-15s %-28s %-10s %-15s %-15s";
		String tieuDe1 = String.format(format1, "Mã SP", "Tên SP", "SL mua", "thương hiệu", "hệ điều hành", 
		"kích thước màn", "chip xử lý", "pin", "Xuất xứ", "giá(VND)");
		String format2  = "%-10s %-20s %-10s %-25s %-15s %-20s";
		String tieuDe2 = String.format(format2, "ID", "Họ và tên", "tuổi", "địa chỉ", "số điện thoại", "email");
		return "                   THÔNG TIN HÓA ĐƠN\nmã hóa đơn : " + getMaHD() 
			+ "\nThông tin khách hàng :\n"+ tieuDe2 + "\n"+ getKhachHang() 
			+ "\nThông tin sản phẩm :\n" + tieuDe1+ "\n" + getdsSanPham()
			+ "\nThành tiền: "  + getThanhTien() + "VND"
			+ "\nThời gian tạo hóa đơn: " + getNgayTaoHD();
	}
}
