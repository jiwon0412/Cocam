class TV {
	public int size;
	public TV(int size) {this.size = size;}
	protected int getSize() {return size;}
}

class ColorTv extends TV {
	public int color;
	public ColorTv(int size, int color) {
		super(size);
		this.color = color;
	}
	public void printProperty() {
		System.out.println(getSize()+"인치 "+color+"컬러");
	}
}


class SmartTV extends ColorTv{
	private String address;
	public SmartTV(String address, int size, int color) {
		super(size,color);
		this.address = address;
		
	}
	public void printProperty() {
		System.out.println("나의 SmartTV는 "+address+" 주소의 "+getSize()+"인치 "+color+"컬러");
	}
	public static void main(String[] args) {
		SmartTV smartTV = new SmartTV("192.168.0.5", 77, 2000000);
		smartTV.printProperty();
	}

}
