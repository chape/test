package basic;

public class Fibonacci {

	/**
	 * 输出小于某数的斐波纳切数组 非递归方式
	 * @param maxNum
	 * @return
	 */
	public static int[] generate(int maxNum){
		if(maxNum == 1){
			return new int[]{1};
		}else if(maxNum == 2){
			return new int[]{1,1};
		}
		
		int numbers[] = new int[maxNum];
		numbers[0]=1;
		numbers[1]=1;
		int index;
		for(index=2;numbers[index-2] + numbers[index-1] < maxNum;index++){
			numbers[index] = numbers[index-2] + numbers[index-1];
		}
		
		int result[] = new int[index];
		System.arraycopy(numbers, 0, result, 0, index);
		
		return result;
	}
	
	/**
	 * 输出小于某数的斐波纳切数组 递归方式
	 * @param maxNum
	 * @return
	 */
	public static int[] generate2(int maxNum){
		if(maxNum == 1){
			return new int[]{1};
		}else if(maxNum == 2){
			return new int[]{1,1};
		}
		
		int numbers[] = new int[maxNum];
		
		int index = 1;
		while(gen(index) < maxNum){
			numbers[index-1] = gen(index);
			index++;
		}
		
		int result[] = new int[index-1];
		System.arraycopy(numbers, 0, result, 0, index-1);
		
		return result;
	}
	
	public static int gen(int num){
		if(num == 1 || num ==2) return 1;
		return gen(num -1) + gen(num -2);
	}
}
