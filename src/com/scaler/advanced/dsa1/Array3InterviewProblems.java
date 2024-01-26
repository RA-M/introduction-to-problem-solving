package com.scaler.advanced.dsa1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array3InterviewProblems {

	public static void main(String[] args) {

		//missingIntegerElement();
		
		//mergeOverlappingIntervals();
		
		Interval[] intervals = new Interval[6];
		intervals[0] = new Interval(1,10);
		intervals[1] = new Interval(2,9);
		intervals[2] = new Interval(3,8);
		intervals[3] = new Interval(4,7);
		intervals[4] = new Interval(5,6);
		intervals[5] = new Interval(6,6);
		//merge(intervals);
		
	}
	/*
	 Given an unsorted integer array, A of size N. Find the first missing positive integer.
	 Note: Your algorithm should run in O(n) time and use constant space. 
	 */
	private static void missingIntegerElement() {
		int[] arr = {1,2,0};
		for (int i = 0; i < arr.length; i++) {
			while((arr[i] > 0) && arr[i] <= arr.length && arr[i] != i+1) {
				int val = arr[i];
				if(arr[i] == arr[val-1]) {
					break;
				}
				int temp = arr[i];
				arr[i] = arr[val-1];
				arr[val-1] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != i+1) {
				System.out.println("Missing "+(i+1));
				break;
			}
		}
	}
//===============================================================================================================
	/*
	 Given a collection of intervals, merge all overlapping intervals. 
	 */
	private static void mergeOverlappingIntervals() {
		int[] start = {0,1,5,6, 7,8,12};
		int[] end   = {2,4,6,8,10,9,14 };
		
		int left = start[0];
		int right = end[0];
		
		for (int i = 1; i < end.length; i++) {
			if(start[i] <= right) {
				right = Math.max(right, end[i]);
			}else {
				System.out.println(left+" "+right);
				left = start[i];
				right = end[i];
			}
		}
		System.out.println(left+" "+right);
	}

	public static Interval[] merge(Interval[] intervals) {
        int start = intervals[0].start;
        int right = intervals[0].end;
        
        List<Interval> list = new ArrayList<>();
        
        for(int i=1; i<intervals.length; i++){
            if(intervals[i].start <= right){
                right = Math.max(right, intervals[i].end);
            }else{
                start = intervals[i].start;
                right = intervals[i].end;
                list.add(new Interval(start, right));
                
            }
        }
        list.add(new Interval(start, right));
        Interval[] newInterval = new Interval[list.size()];
        int index = 0;
        for (Interval inteval : list) {
			newInterval[index] = inteval;
			index++;
		}
        return newInterval;
    }
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int left = 0; 
        int right = 0;
        int index = 1;
        ArrayList<Interval> resultList = new ArrayList<>();
        if(intervals.size()!=0)
        {
            left=intervals.get(0).start;
            right=intervals.get(0).end;
        }
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(index).start <= right){
                right = Math.max(intervals.get(index).end, right);
            }else{
            	resultList.add(new Interval(left, right));
                left = intervals.get(index).start;
                right = intervals.get(index).end;
            }
            index++;
        }
        resultList.add(new Interval(left, right));
        return resultList;
    }
//===============================================================================================================
//===============================================================================================================	
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> ansList = new ArrayList<>();
		int index = 0;
		for (Interval interval : intervals) 
		{
			if(newInterval.start > interval.end) 
			{
				ansList.add(interval);
			}
			else if(newInterval.end < interval.start) 
			{
				ansList.add(newInterval);
				for (int i = index; i < intervals.size(); i++) {
					ansList.add(intervals.get(i));
				}
				return ansList;
			}else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.min(newInterval.end, interval.end);
			}
			index++;
		}
		ansList.add(newInterval);
		return ansList;
    }
	
	
}

	class Interval {
	     int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }