

public class Test2 {

	public static void main(String[] args) {
		
		int result = 0;
		int a[] = { 7, 0, 1, 2, 0, 3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
		Double n=(double) a.length;
		result = countCacheMiss(3, a);
		System.out.println();
		System.out.println("缺页中断次数:" + result);
		System.out.println("缺页率:"+(result/n)*100+"%");
	}
	
	public static int countCacheMiss(int size , int[] pages){
		
		boolean exist_flag = false;//检查是否在缓存中存在
		int memory_cache[] = new int[size];//内存块
		int requests_page_number = pages.length;//请求页的页数
		int time[] = new int[3];//时间计数值
		int time_tmp=0;//记录时间值
		int number = 0;//缺页中断次数
	
		// 先把内存块装满
		for (int i = 0; i < size; i++){
			number++;
			memory_cache[i] = pages[i];
			}
		// 剩下的请求页
		System.out.print("置换的页面：");
		for (int i = size; i < requests_page_number - 1; i++){
			int time_max = 0;
			exist_flag = false;
			// 判断当前请求页是否在内存块中存在
			for (int j = 0; j < size; j++){
				if (memory_cache[j] == pages[i])
					exist_flag = true;
			}
			if (exist_flag)
				continue;
			// 如果缺页，就置换页面
			else{
				number++;
				// 遍历每一个内存块
				for (int j = 0; j < size; j++){
					// 在page_requests请求页中，[i-1]->[0] 依次往前找
					for (int k = i - 1; k >= 0; k--){
						if (memory_cache[j] != pages[k]){
							time_tmp++;
						}
						else {
							time[j] = time_tmp;// 把查询到的time时间值存放到记录数组中
							break;
						}
					}
					time_tmp = 0;
				}
				// 找到内存块中最大的时间值,记为max
				for (int p = 0; p < size; p++){
					if (time[p] > time_max)
						time_max = time[p];
				}
				int p = 0;
				// 找到最大时间值处于数组中的位置
				while (time_max != time[p]){
					p++;
				}
				int c=memory_cache[p];
				memory_cache[p] = pages[i];// 对内存块中改位的页面进行置换
				System.out.print(c+" ");
				
			}
		}
		return number;
	}
}
	



	