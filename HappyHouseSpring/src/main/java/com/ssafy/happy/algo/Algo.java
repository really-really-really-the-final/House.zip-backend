package com.ssafy.happy.algo;

import java.util.List;

import com.ssafy.happy.dto.Notice;

public class Algo {
	private static List<Notice> src;
	private static Notice[] test;
	public static List<Notice> sort(List<Notice> list){
		src=list;
		test= new Notice[src.size()];
		mergeSort(0,src.size()-1);
		return src;
	}
	public static void mergeSort(int start, int end) {
		
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			int p = start;
			int q = mid + 1;
			int idx = p;
			while (p <= mid || q <= end) {
				if (q > end || (p <= mid && 0<src.get(q).getTitle().compareTo(src.get(p).getTitle()))) {
					test[idx++]=src.get(p++);
				} else {
					test[idx++]=src.get(q++);
				}
			}
			for (int i=start;i<=end;i++) { 
				src.set(i, test[i]); 
			}
		}
	}

}
