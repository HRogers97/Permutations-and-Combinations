package com.company;

import java.util.*;

public class Combiner<T> implements Sequences<T, Set<T>> {
    private Collection<T> set; // Set of elements
    private int k; // Number of items in permutations

    public Combiner(Collection<T> set) {
        this.set = set;
        this.k = 3;
    }

    public Combiner(Collection<T> set, int k){
        this.set = set;
        this.k = k;
    }

    @Override
    public Set<Set<T>> generateAll() {
        Set<Set<T>> subSets = new HashSet<>();
        combination(set, new ArrayList<>(), subSets, k, 0, 0);
        return subSets;
    }

    @Override
    public Set<Set<T>> generateSome(int limit) {
        Set<Set<T>> subSets = new HashSet<>();
        combinationLimit(set, new ArrayList<>(), subSets, k, 0, 0, limit);
        return subSets;
    }

    private void combination(Collection<T> set, List<T> currCom, Set<Set<T>> subSets, int m, int pos, int idx){
        //The number of elements left to add to the combination
        //If pos is 0, then the elements left is m
        int elemLeft = m - pos;

        T[] setArr = (T[]) set.toArray();

        for(int i = idx; i <= set.size() - elemLeft; i++){
            currCom.add(setArr[i]);

            if(elemLeft > 1){
                combination(set, currCom, subSets, m, pos + 1, i + 1);
            }
            else{ //Combination found, Add to collection
                //Add all the elements of the current permutation to a new list, and add new list to collection
                Set<T> subSet = new HashSet<>(currCom);
                subSets.add(subSet);
            }

            //Remove the last element from the current combination
            //And keep going through list for more combinations
            currCom.remove(currCom.size() - 1);
        }
    }

    private void combinationLimit(Collection<T> set, List<T> currCom, Set<Set<T>> subSets, int m, int pos, int idx, int limit){
        //The number of elements left to add to the combination
        //If pos is 0, then the elements left is m
        int elemLeft = m - pos;

        T[] setArr = (T[]) set.toArray();

        for(int i = idx; i <= set.size() - elemLeft; i++){
            currCom.add(setArr[i]);

            if(elemLeft > 1){
                combinationLimit(set, currCom, subSets, m, pos + 1, i + 1, limit);
            }
            else{ //Combination found, Add to collection
                //Add all the elements of the current permutation to a new list, and add new list to collection
                Set<T> subSet = new HashSet<>(currCom);
                subSets.add(subSet);
            }

            if(subSets.size() == limit){
                //Limit has been reached, end search for combinations
                break;
            }

            //Remove the last element from the current combination
            //And keep going through list for more combinations
            currCom.remove(currCom.size() - 1);
        }
    }
}
