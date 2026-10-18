package com.hitms.lms;
public class ReportUtil{
    public static double calculateaverage(int[] scores){
        int total =0;
        for(int s:scores){
            total+=s;

        }
        return (double) total/scores.length;
    }
    public static void printreport(int[] scores){
        System.out.println("The average is :"+ calculateaverage(scores));

    }
    public static void main(String[] args) {
        int[] studentScores = {78, 92, 55, 88};
        printreport(studentScores);
    }
}