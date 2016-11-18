package sorting;

/**
 *
 * @author Mahesh Gaonkar
 */

class Heap{
	public void buildHeap(int[] A){
		int n = A.length - 1;
		
		for(int i = n / 2; i >= 1; i--){
			maxHeapify(A, i, n);
		}
	}
	
	public void maxHeapify(int[] A, int i, int n){
		int leftChild = 2 * i;
		int rightChild = (2 * i) + 1;
		
		int largest = i;
		
		if(leftChild <= n && A[leftChild] > A[largest])
			largest = leftChild;
		
		if(rightChild <= n && A[rightChild] > A[largest])
			largest = rightChild;
		
		if(largest != i){
			swap(A,i,largest);
			maxHeapify(A, largest, n);
		}
	}
	
	public void minHeapify(int[] A, int i, int n){
		int leftChild = 2 * i;
		int rightChild = (2 * i) + 1;
		
		int largest = i;
		
		if(leftChild <= n && A[leftChild] < A[largest])
			largest = leftChild;
		
		if(rightChild <= n && A[rightChild] < A[largest])
			largest = rightChild;
		
		if(largest != i){
			swap(A,i,largest);
			maxHeapify(A, largest, n);
		}
	}
	
	public void swap(int[] A, int i, int j){
		int k = A[i];
		A[i] = A[j];
		A[j] = k;
	}
}


public class HeapSort {
	private Heap heap ;
	public HeapSort(){
		heap = new Heap();
	}
	
	public void sort(int A[]){
		heap.buildHeap(A);
		int n = A.length - 1;
		for(int i = n; i > 1; i--){
			heap.swap(A, 1, i);
			n = n - 1;
			heap.maxHeapify(A, 1, n);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {0,4,1,3,2,16,9,10,14,8,7};
		HeapSort heapSort = new HeapSort();
		
		heapSort.sort(A);
		
		for(int value : A){
			System.out.print(value + " ");
		}
	}
}
