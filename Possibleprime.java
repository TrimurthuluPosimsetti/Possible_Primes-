//seive of eratothenesis
import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int v=sc.nextInt();
    String s=Integer.toString(v);
    int temp=v,l=0;
    while(temp>0){
      l=l+1;
      temp=temp/10;
    }    
    int b[]=new int[l];
    for(int i=0;i<l;i++){
      b[i]=Character.getNumericValue(s.charAt(i));
    }
    int a[]=new int[n];
    int c[]=new int[l];
    for(int i=0;i<n;i++){
      a[i]=1;
    }
    for(int i=0;i<l;i++){
      c[i]=0;
    }    
    a[0]=0;
    a[1]=0;
    for(int i=2;i<n;i++){
      if(a[i]==1){
        //System.out.println(i);
        for(int j=2;(i*j)<n;j++){
          a[i*j]=0;
        }
      }
    }
  int in=0; 
  for(int i=0;i<c.length;i++){
    c[in]=b[i];
    if(a[c[0]]==1){
      System.out.println(c[0]);
    }
  possiblePrimes(a,c,1,b);}
  }
  public static void possiblePrimes(int a[],int c[],int in,int b[]){
    for(int i=0;i<c.length;i++){
      if(place(c,b[i])){
          c[in]=b[i];
          String s="";
          for(int j=0;j<c.length;j++){
            if(c[j]!=0){
              s=s+String.valueOf(c[j]);}
          }
          //System.out.println(s);
          //System.out.println(s+" "+c.length);
          if(s!=""){
          if(a[Integer.parseInt(s)]==1){
            System.out.println(s);
          }}
          else{
          possiblePrimes(a,c,in+1,b);
          c[in+1]=0;}
      }
    }
  }
  public static boolean place(int c[],int v){
    for(int i=0;i<c.length;i++){
      if(c[i]==v){
        return false;
      }
    }
    return true;
  } 
}
