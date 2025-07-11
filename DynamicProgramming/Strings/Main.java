package DynamicProgramming.Strings;

//  In Array DP Problems -> We had pick and not-pick.
//

//  In String DP Problems -> We have MATCH AND NOT-MATCH.

//  Pseudocode:
//
//  f(idx1, idx2){
//  base-case -> any of the index goes out of bounds -> negative
//  if(idx1 < 0 || idx2 < 0)    return 0;
//  if character at index match
//  if(str1[idx1] == str2[idx2]
//      return 1 + f(idx1 - 1, idx2 - 1)
//
//  if not matching -> 2 possibilities -> looking for LCM -> so taking Max
//  return Math.max(f(idx1, idx2 - 1), f(idx1 - 1, idx2)


public class Main {
}
