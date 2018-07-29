package com.orange;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        // write your code here
        int[][][] matrix = createTargets();

        Map<Integer, Set<Integer>> clusterMapping = new HashMap<>();
        HashSet<Integer> globalClusterIndies = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Set<Integer> currentCuster = new HashSet<>();
                if (!globalClusterIndies.contains(i * 10 + j)) {
                    Set<Integer> currentCluster = dfsSearch(matrix, i, j, globalClusterIndies, currentCuster);
                    if (!currentCluster.isEmpty()) {
                        clusterMapping.put(i * 10 + j, currentCluster);
                    }
                }
            }
        }




        System.out.println(clusterMapping);
    }

    private static int[][][] createTargets() {
        List<Integer> targets = new ArrayList<>();
        targets.add(7);
        targets.add(110);
        targets.add(114);
        targets.add(123);
        targets.add(125);
        targets.add(135);
        targets.add(137);
        targets.add(212);
        targets.add(222);
        targets.add(227);
        targets.add(234);
        targets.add(243);
        targets.add(240);
        targets.add(330);
        targets.add(355);
        targets.add(442);
        targets.add(444);
        targets.add(453);
        targets.add(454);
        targets.add(463);
        targets.add(127);
        targets.add(230);

        targets.add(357);
        targets.add(460);


        //create matrix
        int a[][][] = new int[7][7][8];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 8; k++) {
                    int index = i * 100 + j * 10 + k;
                    if (targets.contains(index)) {
                        a[i][j][k] = 1;
                    } else {
                        a[i][j][k] = 0;
                    }
                }

            }
        }
        return a;
    }

    private static Set<Integer> dfsSearch(int[][][] matrix, int i, int j, Set<Integer> globalCusterIndies, Set<Integer> currentCuster) {

        globalCusterIndies.add(i * 10 + j);
        List<Integer> connectionsPositions = new ArrayList<>();
        for (int k = 0; k < 8; k++) {
            if (matrix[i][j][k] == 1) {
                connectionsPositions.add(k);
            }
        }

        if (!connectionsPositions.isEmpty()) {
            return connectionsPositions.stream().map(position -> {
                int[] index = calculateIndex(position, i, j);
                int newRow = index[0];
                int newColumn = index[1];
                int newIndex = newRow * 10 + newColumn;
                if (!globalCusterIndies.contains(newIndex)) {
                    globalCusterIndies.add(newIndex);
                    currentCuster.add(newIndex);
                    return dfsSearch(matrix, newRow, newColumn, globalCusterIndies, currentCuster);
                } else {
                    return currentCuster;
                }
            }).flatMap(Collection::stream)
                    .collect(Collectors.toSet());
        } else {
            return currentCuster;
        }

    }

    private static int[] calculateIndex(int position, int currentRow, int currentColumn) {
        int[] index = new int[2];
        switch (position) {
            case 0:
                currentRow = currentRow - 1;
                currentColumn = currentColumn - 1;
                break;
            case 1:
                currentRow = currentRow - 1;
                break;
            case 2:
                currentRow = currentRow - 1;
                currentColumn = currentColumn + 1;
                break;
            case 3:
                currentColumn = currentColumn - 1;
                break;
            case 4:
                currentColumn = currentColumn + 1;
                break;
            case 5:
                currentRow = currentRow + 1;
                currentColumn = currentColumn - 1;
                break;
            case 6:
                currentRow = currentRow + 1;
                break;
            case 7:
                currentRow = currentRow + 1;
                currentColumn = currentColumn + 1;
                break;
        }
        index[0] = currentRow;
        index[1] = currentColumn;
        return index;
    }



}
