package sort;

import java.util.Scanner;
import java.applet.*;

public class dui {
	public static void maxheap(int[] A,int last){
		for(int i=(last-1)/2;i>=0;i--){
			int k=i;
		    while(2*k+1<=last){//�ж����޺��ӽڵ�
		    	int big=2*k+1;//����
		    	if(big<last){//�ж������Һ���
		    		if(A[big]<A[big+1]){
		    			big++;
		    		}
		    	}
		    	if(A[k]<A[big]){//���ڵ�������ӽڵ�ıȽ�
		    		if(k!=big){
		    			A[k]=A[k]+A[big];
				    	A[big]=A[k]-A[big];
				    	A[k]=A[k]-A[big];
		    		}	
		    		k=big;
			    }
		    	else{
		    		break;
		    	}
		    }
		    
		}
		
	}
	public static void dui(int[] A){
		for(int i=0;i<A.length;i++){
			maxheap(A,A.length-i-1);
			if(0!=A.length-i-1){
    			A[0]=A[0]+A[A.length-i-1];
		    	A[A.length-i-1]=A[0]-A[A.length-i-1];
		    	A[0]=A[0]-A[A.length-i-1];
    		}
		}
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int A[]=new int[n];
		for(int i=0;i<n;i++){
			A[i]=in.nextInt();
		}
		dui(A);
		for(int i=0;i<n;i++){
			System.out.print(A[i]+" ");
		}
	}
}
