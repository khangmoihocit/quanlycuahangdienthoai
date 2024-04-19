package quanly;
import java.util.Scanner;

public class KhachHang extends ConNguoi{
	private String sdt, email;

	public KhachHang(String id, String ten, String tuoi, String diaChi, String sdt, String email) {
		super(id, ten, tuoi, diaChi);
		this.sdt = sdt;
		this.email = email;
	}
	public KhachHang() {
		super();
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Id khách hàng: "); setId(sc.nextLine());
		System.out.print("Họ tên khách hàng: ");   setTen(sc.nextLine());
		System.out.print("Tuổi: "); setTuoi(sc.nextLine());
		System.out.print("Địa chỉ: "); setDiaChi(sc.nextLine());
		System.out.print("Số điện thoại: "); setSdt(sc.nextLine());
		System.out.print("Email: "); setEmail(sc.nextLine());
	}
	@Override
	public String toString() {
		String fomatString = "%-15s %-25s";
		return super.toString() + String.format(fomatString, getSdt(), getEmail());
	}
}
