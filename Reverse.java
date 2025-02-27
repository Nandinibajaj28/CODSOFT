import java.util.*;


public class Reverse{
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6};
        RArray(arr);
        for(int i=0;i<=arr.length-1;i++){
            System.out.println(arr[i]);

        }
        
        


    }

    public static void RArray(int arr[]){
        int s=0;
        int e=arr.length-1;
        while(s<e){
            int temp=arr[e];
            arr[e]=arr[s];
            arr[s]=temp;

            s++;
            e--;
        }
       


    }
}

