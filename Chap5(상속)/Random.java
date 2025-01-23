
public class Random {
	public static void main(String[] args) {
		int array[] = new int[10]; // 10개 배열 생성
		
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*101 +100); // 100~200사이의 랜덤숫자 10개 생성
			System.out.println(array[i]);
		}

		int sum=0;
		
		for(int i=0; i<array.length; i++) {
			sum += array[i];
		}
		
		int mid = sum / array.length;
		
		System.out.println("평균: "+mid);
	}
}
