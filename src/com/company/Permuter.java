package com.company;

import java.util.*;

public class Permuter<T> implements Sequences<T, List<T>> {
    private Collection<T> set; // Set of items
    private int k; // Number of items in permutations

    public Permuter(Collection<T> set) {
        this.set = set;
        this.k = 3;
    }

    public Permuter(Collection<T> set, int k) {
        this.set = set;
        this.k = k;
    }

    @Override
    public Set<List<T>> generateAll() {
        Set<List<T>> subSets = new HashSet<>();
        permutation(set, new ArrayList<>(), subSets, k, 0);
        return subSets;
    }

    @Override
    public Set<List<T>> generateSome(int limit) {
        Set<List<T>> subSets = new HashSet<>();
        permutationLimit(set, new ArrayList(), subSets, k, 0, limit);
        return subSets;
    }

    private void permutation(Collection<T> set, List<T> currPerm, Set<List<T>> subSets, int k, int pos){
        T[] setArr = (T[]) set.toArray();

        for(int i = 0; i < set.size(); i++){
            //Skip if the current permutation already contains this element
            if(currPerm.contains(setArr[i]))
                continue;

            currPerm.add(setArr[i]);

            if(pos < (k - 1)){
                //Last element of permutation has not been reached, keep looking for more elements
                permutation(set, currPerm, subSets, k, pos + 1);
            }
            else{ //Permutation has been found, add to collection
                //Add all the elements of the current permutation to a new list, and add new list to collection
                List<T> subSet = new ArrayList<>(currPerm);
                subSets.add(subSet);
            }

            //Remove last element in the current permutation
            //And keep going through list for more permutations
            currPerm.remove(currPerm.size() - 1);
        }
    }

    private void permutationLimit(Collection<T> set, List<T> currPerm, Set<List<T>> subSets, int k, int pos, int limit){
        T[] setArr = (T[]) set.toArray();

        for(int i = 0; i < set.size(); i++){
            //Skip if the current permutation already contains this element
            if(currPerm.contains(setArr[i])){
                continue;
            }

            currPerm.add(setArr[i]);

            if(pos < (k - 1)){
                //Last element of permutation has not been reached, keep looking for more elements
                permutationLimit(set, currPerm, subSets, k, pos + 1, limit);
            }
            else{ //Permutation has been found, add to collection
                List<T> subSet = new ArrayList<>(currPerm);
                subSets.add(subSet);
            }

            if(subSets.size() == limit){ //Limit has been reached, end search for permutations
                break;
            }

            //Remove last element in the current permutation
            //And keep going through list for more permutations
            currPerm.remove(currPerm.size() - 1);
        }
    }
}

