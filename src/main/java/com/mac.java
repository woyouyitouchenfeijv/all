package com;
import java.util.*;
/**
 * @Description
 * @Date 2023/3/27
 */
public class mac {



    public static class Main {
        public static long sum;
        public static int n,p,t;
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            n=sc.nextInt();
            t=sc.nextInt();
            p=sc.nextInt();
            int[][] a=new int[n][6];
            for(int i=0;i<n;i++){
                for(int j=0;j<5;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            dfs(0l,0,a);
            System.out.println(sum);
        }
        static void dfs(long fs,int sj,int[][] a){
            sum=Math.max(fs,sum);
            for(int i=0;i<n;i++){
                if(a[i][5]==0&&(sj+a[i][3])<=t){
                    a[i][5]=1;
                    sj+=a[i][3];
                    fs=fs+Math.max(a[i][2],a[i][0]-sj*a[i][1]-a[i][4]*p);
                    dfs(fs,sj,a);
                    fs-=Math.max(a[i][2],a[i][0]-sj*a[i][1]-a[i][4]*p);
                    a[i][5]=0;
                    sj-=a[i][3];
                }
            }
        }
    }

}
