package quanly;

import java.util.ArrayList;
import java.util.Scanner;

public class SanPham {
	private String maSP, tenSP, soLuongSP , thuongHieu, heDieuHanh, kichThuocMan, chip, pin, xuatXu, giaString;
	
	private int soLuongMua; // số lượng mua sản phẩm trong hóa đơn
	static int a = 0;
	//khởi tạo mã sản phẩm tự động tăng
	public static String maSP(String s, int a) {
		String res = "";
		if (a>=0 && a<10) {
			res = "00" + s;
		}
		else if (a>=10 && a<=99) {
			res = "0" + s;
		}else {
			res = s;
		}
		return res;
	}
	public SanPham() {
		a++;
		String s = String.valueOf(a);
		this.maSP = maSP(s, a);
	}
	public SanPham(String tenSP, String soLuong, String thuongHieu, String heDieuHanh, String kichThuocMan,
			String chip, String pin, String xuatXu, String giaString) {
		a++;
		String s = String.valueOf(a);
		this.maSP = maSP(s, a);
		this.tenSP = tenSP;
		this.soLuongSP = soLuong;
		this.thuongHieu = thuongHieu;
		this.heDieuHanh = heDieuHanh;
		this.kichThuocMan = kichThuocMan;
		this.chip = chip;
		this.pin = pin;
		this.xuatXu = xuatXu;
		this.giaString = giaString;
	}

	//dùng để chuyển lại giá tiền, vì giá tiền đang có dạng là 100.000.000VND
	public String chuanHoa(String s) {
		ArrayList<String> arr = new ArrayList<String>();
		String[] a = s.split("");
		for (int i=0; i<a.length; ++i) {
			arr.add(a[i]);
		}
		String res = "";
		for (int i=0; i< arr.size(); ++i) {
			if (arr.get(i).equals(".")) {
				arr.remove(i);
			}
			if (arr.get(i).equals("V")) {
				arr.remove(i);
			}
			if (arr.get(i).equals("N")) {
				arr.remove(i);
			}
			if (arr.get(i).equals("D")) {
				arr.remove(i);
			}
			else {
				res+= arr.get(i);
			}
		}
		return res;
	}
	
	//giam so luong san pham trong kho khi mua hang thanh cong
	public void capNhatSoLuong(int soLuong){
		int sl = Integer.parseInt(getSoLuong());
		while(true){
			if (soLuong <= sl){
				setSoLuongMua(soLuong);
				sl = sl - soLuong;
				//cap nhat so luong mua
				break;
			}
			else{
				System.out.println("Số lượng sản phẩm trong kho không đủ! Vui lòng nhập lại.");
				System.out.print("Số lượng: ");
				soLuong = new Scanner(System.in).nextInt();
			}
		}
		setSoLuong(String.valueOf(sl));
	}
	
	//nhập thông tin sản phẩm từ bàn phím
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên sản phẩm: "); setTenSP(sc.nextLine());
		System.out.print("số lượng: "); setSoLuong(sc.nextLine());
		System.out.print("thương hiệu sp: "); setThuongHieu(sc.nextLine());
		System.out.print("hệ điều hành: "); setHeDieuHanh(sc.nextLine());
		System.out.print("kích thước màn hình: "); setKichThuocMan(sc.nextLine());
		System.out.print("chip xử lý: ");setChip(sc.nextLine());
		System.out.print("pin: ");setPin(sc.nextLine());
		System.out.print("xuất xứ: ");setXuatXu(sc.nextLine());
		System.out.print("giá SP: ");setGiaString(sc.nextLine());
	}
	
	public int getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getSoLuong() {
		return soLuongSP;
	}

	public void setSoLuong(String soLuong) {
		this.soLuongSP = soLuong;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public String getHeDieuHanh() {
		return heDieuHanh;
	}

	public void setHeDieuHanh(String heDieuHanh) {
		this.heDieuHanh = heDieuHanh;
	}

	public String getKichThuocMan() {
		return kichThuocMan;
	}

	public void setKichThuocMan(String kichThuocMan) {
		this.kichThuocMan = kichThuocMan;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public String getGiaString() {
		return giaString;
	}

	public void setGiaString(String giaString) {
		this.giaString = giaString;
	}
	
	@Override
	public String toString() {
		String format = "%-5s %-20s %-5s %-15s %-15s %-15s %-28s %-10s %-15s %-15s";
		return String.format(format, getMaSP(), getTenSP(), getSoLuong(), getThuongHieu(), getHeDieuHanh(),
				getKichThuocMan(), getChip(), getPin(), getXuatXu(), getGiaString());
	}
	public String getSoLuongSP() {
		return soLuongSP;
	}
	public void setSoLuongSP(String soLuongSP) {
		this.soLuongSP = soLuongSP;
	}

	//tạo hash code và equals để so sánh sản phẩm khi cho vô set ở class kho
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenSP == null) ? 0 : tenSP.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		if (tenSP == null) {
			if (other.tenSP != null)
				return false;
		} else if (!tenSP.equals(other.tenSP))
			return false;
		return true;
	}
	
	//hien san pham trong hoa don
	public String toStringHD() {
		String format = "%-5s %-20s %-10s %-15s %-15s %-15s %-28s %-10s %-15s %-15s";
		return String.format(format, getMaSP(), getTenSP(), getSoLuongMua(), getThuongHieu(), getHeDieuHanh(),
				getKichThuocMan(), getChip(), getPin(), getXuatXu(), getGiaString());
	}
}
