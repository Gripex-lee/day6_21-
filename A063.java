package day6_21;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A063 {
	 // 函数
    public static void sortKSortedArray(List<Integer> list, int k){
        //创建一个空堆并在堆中插入第一个k + 1元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(list.subList(0, k+1));
        int index = 0;
        // 对数组的其余元素做处理
        for (int i = k + 1; i < list.size(); i++){
        	//从最小堆中弹出顶层元素并将其分配给下一个可用的数组索引
            list.set(index++, pq.poll());
            //将下一个数组元素推入最小堆
            pq.add(list.get(i));
        }
        // 从最小堆中弹出所有剩余的元素并将其分配给下一个可用的数组索引
        while(!pq.isEmpty()){
            list.set(index++, pq.poll());//poll方法每次从头部删除一个数
        }
    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        Scanner br=new Scanner(System.in);
        for(int i=0;i<10;i++) {
        	list.add(br.nextInt());
        }
        int k = br.nextInt();
        sortKSortedArray(list, k);
        for(int i=0;i<list.size();i++) {
        	System.out.print(list.get(i)+" ");
        }
    }
}
