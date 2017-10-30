public class Pascal {
	public static void main(String[] args) {
		printPascal(4);
	}
	public static void printPascal(int num) {
		int[][] value = new int[num][num];  
        for(int i = 0; i < num ;i++){  
            value[i][0] = 1;  
            value[i][i] = 1;  
            if(i > 1){  
                for(int j = 1; j < i ;j++){  
                    value[i][j] = value[i-1][j-1] + value[i-1][j];  
                }  
            }  
        }  
        for(int i = 0; i < num ;i++){  
            for(int k = 0; k <= num - i;k++){  
                System.out.print("   ");  
            }  
            for(int j = 0; j<= i ;j++){  
                System.out.print(value[i][j]+"     ");  
            }  
            System.out.println();  
        }  
	}
	
	
}
