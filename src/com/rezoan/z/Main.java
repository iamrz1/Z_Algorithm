package com.rezoan.z;

import java.util.Scanner;

public class Main {

		public static void main(String[] args) {
			Scanner scan = new Scanner (System.in);
			System.out.println("Enter String: ");
			String line=scan.nextLine();
			
			System.out.println("Enter pattern: ");
			String pattern=scan.nextLine();
			if (line.isEmpty())line="ATCGAATCGCAGATCGCTGGA";
			if (pattern.isEmpty())pattern="TCG";
			System.out.println("Line = "+line);
			System.out.println("Pattern = "+pattern);
			
			char [] input=(pattern+"$"+line).toCharArray();
		 
	        int zValue[] = new int[input.length];
	        int left = 0;
	        int right = 0;
	        for(int index = 1; index < input.length; index++) {
	            if(index > right) {
	                left = right = index;
	                while(right < input.length && input[right] == input[right - left]) {
	                    right++;
	                }
	                zValue[index] = right - left;
	                right--;
	            } 
	            else {
				      //inside the box ( index<=right side of the box )
			        int k = index - left;
			        
			        if(zValue[k] < right - index + 1) {
			            zValue[index] = zValue[k];
			        } 
			        else { 
			            left = index;
			            while(right < input.length && input[right] == input[right - left]) {
			                right++;
			            }
			            zValue[index] = right - left;
			            right--;
			            }
		        }
	        }
	        
	        //printing the matches
	        
	        for(int i = 0; i < input.length; i++){
	        	if (zValue[i]==pattern.length()){
	        		System.out.println("Pattern matches at index: "+( i-1-pattern.length() ));}
	        }
	        
		
	}

}
