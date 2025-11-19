public class DSA1{
    public static void main(String []args){
        int[] arr={3,7,2,9,4};
        int[] res = smallestAndLargest(arr);
        System.out.println("Smallest = "+res[0]+" ,Largest = " +res[1]);
    }

    public static int[] smallestAndLargest(int[] arr){
        int[] x=new int[2];
        int small=10000;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<small){
                small=arr[i];
            }
        }
        int large=-90;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>large){
                large=arr[i];
            }
        }
        x[0]=small;
        x[1]=large;
        return x;
    }
}