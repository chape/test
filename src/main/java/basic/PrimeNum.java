package basic;

public class PrimeNum {

	/**
	 *  获取小于某数的所有素数
	 * @param maxNum
	 * @return
	 */
	public static int[] getPrimeNum(int maxNum){
		if(maxNum <= 2){
			return new int[]{};
		}
		int numbers[] = new int[maxNum];
		int count=0;
		for(int i=2;i<maxNum;i++){
			if(isPrimeNum(i)){
				numbers[count] = i;
				count++;
			}
		}
		int result[] = new int[count];
		System.arraycopy(numbers, 0, result, 0, count);
		return result;
		
	}
	/**
	 * 判断某数是否为素数,素数只能被自己和1整除
	 * @param num
	 * @return
	 */
	public static boolean isPrimeNum(int num){
		int count = 0;
		for(int i=1;i<=num;i++){
			if(num%i == 0){
				count++;
			}
		}
		return count == 2;
	}
	
}
