package lyc.algorithm;
/**
 * 排序算法
 * @author lyc
 *
 */
public class Sort {

	public static void main(String[] args) {
		int[] sort = {6,2};
		//				bubbleSort(sort);
		//		middleSort(sort,0,sort.length-1);
		insertSort(sort);
		for(int i=0;i<sort.length;i++) {
			System.out.print(sort[i]+" ");
		}
	}
	/**
	 * 冒泡排序
	 * 效率低  实现简单   从小到大
	 * 比较相邻的两个元素，从第一个到最后一个，把最大的放到最后
	 * 针对所有元素重复以上，除了最后一个（上一步已经排序出的）
	 * 每次重复的次数越来越少，直到没有
	 */
	public static void bubbleSort(int[] sort) {
		int temp = 0;
		for(int i = 0;i<sort.length-1;i++) {
			for(int j=0;j<sort.length-1-i;j++) {
				if(sort[j]>sort[j+1]) {
					temp = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = temp;
				}
			}
		}
		for(int i=0;i<sort.length;i++) {
			System.out.print(sort[i]+" ");
		}
	}

	/**
	 * 选择排序  
	 * 每趟从待排序的记录序列中选择关键字最小的记录放置到已排序表的最前位置，直到全部排完。
	 * 和冒泡排序区别：
	 *		冒泡排序 是依次两两对比
	 * 		选择排序 是i和  不同的j（j++）比较
	 * 
	 * @param sort
	 */
	public static void selectSort(int[] sort) {
		int t =0;
		//从大到小排序
		for(int i=0;i<sort.length;i++) {
			for(int j=i+1;j<sort.length;j++) {
				if(sort[i]<sort[j]) {
					t = sort[i];
					sort[i] = sort[j];
					sort[j] = t;
				}
			}
		}
		for(int i=0;i<sort.length;i++) {
			System.out.print(sort[i]+" ");
		}
	}

	/**
	 * 快速排序
	 * 首先设置一个轴值pivot，然后以这个轴值为划分基准将待排序序列分成比pivot大和比pivot小的两部分，
	 * 接下来对划分完的子序列进行快排直到子序列为一个元素为止。
	 * @param start  0
	 * @param end  数据长度-1
	 * @param sort
	 */
	public static void middleSort(int[] sort,int start,int end) {
		if(start == end) {
			return;
		}
		int middleValue,middleKey; //value:对比值    key：位置
		if(start<end) {
			int t = 0;
			middleKey = start;
			middleValue = sort[start];
			for(int i= start+1;i<=end;i++) 
				if(sort[i]>middleValue) {
					middleKey++;
					t = sort[middleKey];
					sort[middleKey] = sort[i];
					sort[i] = t;
				}
			t = sort[middleKey];
			sort[middleKey] = middleValue;
			sort[start] = t;
			middleSort(sort,start,middleKey-1);
			middleSort(sort,middleKey+1,end);
		}
	}

	/**
	 * 插入排序 
	 * 将数组分为两部分，将后部分元素逐一与前部分元素比较，
	 * 如果当前元素sort[i]小，就替换。找到合理位置插入sort[i]
	 * 
	 * 只要比选定的数大  前一位移到后一位
	 * @param sort
	 */
	public static  void insertSort(int[] array) {
		int t,m;
		for(int i =1;i<array.length;i++) {
			if(array[i]<array[i-1]) {
				t = array[i];
				for(m = i-1;m>=0 && t<array[m];m--) {
					array[m+1] = array[m]; 
				}
				array[m+1] =t;
			}
		}
	}

}
