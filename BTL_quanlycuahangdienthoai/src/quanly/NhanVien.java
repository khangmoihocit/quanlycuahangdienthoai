package quanly;

public class NhanVien extends ConNguoi{
	private double luong;

	public NhanVien(String id, String ten, String tuoi, String diaChi, double luong) {
		super(id, ten, tuoi, diaChi);
		this.luong = luong;
	}
	public NhanVien() {
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	@Override
	public String toString() {
		String fomatString = "%-15s";
		return super.toString() + String.format(fomatString, luong);
	}
	
}
