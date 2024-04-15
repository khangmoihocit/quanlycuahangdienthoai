package quanly;

public class ConNguoi {
	private String id, ten, tuoi, diaChi;

	public ConNguoi(String id, String ten, String tuoi, String diaChi) {
		this.id = id;
		this.ten = ten;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
	}
	public ConNguoi() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		String fomatString = "%-10s %-20s %-10s %-25s";
		return String.format(fomatString, getId(), getTen(), getTuoi(), getDiaChi());
	}
	
	
	
}
