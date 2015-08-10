package Cool;

import java.util.Scanner;

public class ImplementHashTable {
	
	int [] arr;
	int capacity;
	
	public ImplementHashTable(int capacity){
		this.capacity = nextPrime(capacity);
		arr = new int [this.capacity];
	}
	
	//function for insertion
	public void insert(int element){
		/*10
		 * insert 5
		 * arr[5%10] = 5 -- arr[5] = 5
		 * insert 15
		 * arr[5] = 15
		 * insert 155
		 * arr[5] = 155
		 */
		int temp;
		if(contains(arr[element % capacity]) && arr[element % capacity] != 0){
			if(contains(arr[++element % capacity]) && arr[++element % capacity] < element){
				arr[++element % capacity] = element;
			}
			for(int i = element % capacity; i >= 0;i--){
				if(!contains(arr[i])){
					arr[i] = element;
				}
			}
		}else{
			arr[element % capacity] = element;
		}


	}
	
	public void clear(){
		arr = new int[capacity];
	}
	
	public boolean contains(int e){
		return arr[e % capacity] == e;
	}
	
	public void delete(int e){
		if(arr[e % capacity] == e){
			arr[e%capacity] = 0;
		}else{
			System.out.println("Element not found!");
		}
	}
	
	private static int nextPrime(int n){
		if(n % 2 == 0) n++;
		for(; !isPrime(n); n+=2);
		return n;
	}
	
	private static boolean isPrime(int n){
		if(n == 2 || n == 3) return true;
		if(n == 1 || n % 2 == 0) return false;
		for(int i = 3; i * i <= n; i+=2){
			if(n % i == 0) return false;
		}
		return true;
	}
	
	public void printTable(){
		System.out.println("\nHash Table = ");
		for(int i = 0; i < capacity; i++){
			System.out.println(arr[i] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size: ");
		
		ImplementHashTable ht = new ImplementHashTable(scan.nextInt());
		char ch;
		
		do{
			System.out.println("\nHash Table Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. remove");
			System.out.println("3. contains");            
			System.out.println("4. clear");            

			int choice = scan.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter integer element to insert");
				ht.insert(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter integer element to delete");
				ht.delete(scan.nextInt());
				break;
			case 3:
				System.out.println("Enter integer element to check if present");
				System.out.println("Contains : "+ht.contains(scan.nextInt()));
				break;
			case 4:
				ht.clear();
				System.out.println("Hash Table Cleared\n");
				break;
			default:
				System.out.println("Wrong entry \n");
				break;
			}
			
			ht.printTable();
			
			System.out.println("\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		}while(ch == 'Y' || ch == 'y');

	}

}
