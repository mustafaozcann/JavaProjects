import java.util.Scanner;

public class Sample {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] array = new int[10];
		
		
		for(int i = 0; i < array.length;i++) {
			System.out.print("Enter number :");
			array[i] = scanner.nextInt();
		}
		scanner.close();
		
		toSort(array);
		
		
	}

	public static void toSort(int[] array) {
		
		int minValue = array[0];
		
		
		for(int i = 0; i < array.length;i++) {
			
			for(int j = 0; j < array.length-1;j++) {
				
				if(array[j] > array[j+1]) {
					minValue = array[j+1];
					array[j+1] = array[j];
					array[j] = minValue;
				}
			}
		}
		
		for(int i : array) {
			System.out.printf("%d< ",i);
		}
	}
}
