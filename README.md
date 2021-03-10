# Permutations and Combinations
Contains two classes Permuter and Combiner. Both of these classes take in a collection of elements and find permutations/combinations within those collections. These classes contain two functions:

### generateAll()
This will return a list of all permutations/combinations found in the collection of elemnts

### generateSome(int limit)
This will return a list of permutations/combinations up to the limit specified

Both classes may also take in the optional value k which determins how many items to find permutations/combinations of. By default this value is 3

## Example					  
A Permuter object with the collection [1,2,3] will return: [1, 2, 3], [3, 2, 1], [2, 1, 3], [3, 1, 2], [1, 3, 2], [2, 3, 1]

A Combiner object with the same collection and k set to 2 will return: [1, 2], [1, 3], [2, 3]
