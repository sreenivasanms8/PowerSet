package com.company;

import java.util.*;

/**
 * When executing the program, if you get an OutOfMemory/Java-Heap-Space or Insufficient Memory error,
 * try to increase the memory allotted to Java depending on your computer's RAM capability.
 *
 * The number of sets that compose the PowerSet is 2^n, where n is the number of elements in the Entry Set.
 */

public class PowerSet {

    public static void main(String[] args){

        double startTime = System.currentTimeMillis();

        /**
         * Enter the Entry Set below.
         */
        int[] arraySeq = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        ArrayList<int[]> iterationsArray = new ArrayList<int[]>();

        for (int i = 0; i < arraySeq.length; i++){

            int element;
            element = arraySeq[i];

            if (i == 0){
                dumpToArrList(element, iterationsArray);
            }
            else{
                cloneAddDumpToArrList(element, iterationsArray);
                dumpToArrList(element, iterationsArray);
            }
        }

        /**
         * The iterationsArray that is built below gives the PowerSet P(S) of the Entry Set S.
         **/
        printArraysInList(iterationsArray);
        System.out.println();

        double endTime = System.currentTimeMillis();
        double TotalTime = endTime-startTime;
        System.out.println("The total time it took to execute this algorithm was "+TotalTime+ " ms.");

    }

    static void dumpToArrList (int elem, ArrayList<int[]> iterationsArray){
        int[] temparray = new int[1];
        temparray[0] = elem;
        iterationsArray.add(temparray);
    }

    static void cloneAddDumpToArrList(int elem, ArrayList<int[]> iterationsArray){

        ArrayList<int []> iterationsArrayClone = (ArrayList<int []>) iterationsArray.clone();

        for (int i = 0; i < iterationsArrayClone.size(); i++){

            int[] existarray = iterationsArrayClone.get(i);

            int[] temparray= new int[((iterationsArrayClone.get(i).length)+1)];

            int n = temparray.length;

            int element  = elem;

            for (int j = 0; j < existarray.length; j++){
                temparray[j] = existarray[j];
            }
            temparray[n-1] = element;

            iterationsArray.add(temparray);

        }

    }

    static void printArraysInList(ArrayList<int[]> iterationsArray){

            int i;
            for (i = 0; i < iterationsArray.size(); i++) {

                    System.out.println("");

                    int x;

                    System.out.print("At position " +(i+1)+ " in the arraylist: ");

                    int[] temparr = iterationsArray.get(i);
                    System.out.print("The array is [");
                    for (int j = 0; j < temparr.length; j++) {
                        System.out.print(temparr[j] + " ");
                    }
                    System.out.print("]." + " ");
            }

            System.out.println();
            System.out.println("At position "+(i+1)+" the array is the empty set [] 'or' ∅.");
            System.out.println();
            System.out.println("The number of sets that compose the PowerSet is "+(iterationsArray.size()+1)+".");

    }

}