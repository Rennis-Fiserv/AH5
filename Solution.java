import java.util.HashMap;
class Solution {
    public static char mostFrequentChar(String s) {
      
      HashMap<Character, Integer> map = new HashMap<>();
      HashMap<Character, Integer> order = new HashMap<>();

      char[] s2 = s.toCharArray();

      for(char c : s2){
        map.put(c,map.getOrDefault(c,0)+1);
      }

      for(int i = 0; i < s2.length;i++){
        if(!order.containsKey(s2[i])){
          order.put(s2[i],i);
        }
      }

      char ans = s.charAt(0);
      int freq = 0;

      for(char c :map.keySet()){
        if(map.get(c) > freq){
          ans = c;
          freq = map.get(c);
        }
        else if (map.get(c) == freq){
          if(order.get(c)<order.get(ans)){
            ans = c;
          }
        }
      }
      return ans;
    }
  
    public static void main(String[] args) {
      // Try out your test cases:
      System.out.println(Solution.mostFrequentChar("bookeeper")); // -> 'e'
      System.out.println(Solution.mostFrequentChar("david")); // -> 'd'
      System.out.println(Solution.mostFrequentChar("mississippi")); // -> 'i'
      System.out.println(Solution.mostFrequentChar("eleventennine")); // -> 'e'
    }

  }
