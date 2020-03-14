package com.company;

import java.util.Scanner;
/**
 * @author  ly
 * @date  ${DATE} ${TIME}
 * @version 1.0
 */
public class Main {
    private static final int K=2;
    private static int n;
    //迷宫大小

    private static int[][] maze;
    //迷宫矩阵

    private static int min;
    //记录最短步长

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请输入：");
        n=s.nextInt();
        min = n * n;
        maze=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                maze[i][j]=s.nextInt();
            }
        }
        path(1,1,0);
        //起始坐标，初始步长为0
        if(min>0) {
            System.out.print(min);
        }
        else {
            System.out.print("NO solution");
        }
    }
    private static void path(int a, int b, int count) {
        if(a==n-K && b==n-K)
            //终点
        {
            min = Math.min(count, min);
        } else {
            maze[a][b]=1;
            //标记该点，设为障碍物，防止在递归过程中无限循环
            if(b<n-1 && maze[a][b+1]==0) {
                path(a, b+1, count+1);
                //向右走
            }
            if(b>1 && maze[a][b-1]==0) {
                path(a, b-1, count+1);
                //向左走
            }
            if(a>1 && maze[a-1][b]==0) {
                path(a-1, b, count+1);
                //向上走
            }
            if(a<n-1 && maze[a+1][b]==0) {
                path(a + 1, b, count + 1);
                //向下走
            }
            maze[a][b]=0;
            //当从这个节点出发的所有节点都已经尝试过，清除标记

        }
    }
}
