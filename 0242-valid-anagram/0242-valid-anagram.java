class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] counter = new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for(int c:counter){
            if(c!=0) return false;
        }
        return true;






        // HashMap<Character,Integer> sMap=new HashMap<>();
        // HashMap<Character,Integer> tMap=new HashMap<>();

        // for(int i=0;i<s.length();i++){
        //     if(sMap.containsKey(s.charAt(i)))
        //     sMap.put(s.charAt(i),(sMap.get(s.charAt(i)))+1);
        //     else sMap.put(s.charAt(i),1);
        //     if(tMap.containsKey(t.charAt(i)))
        //     tMap.put(t.charAt(i),(tMap.get(t.charAt(i)))+1);
        //     else tMap.put(t.charAt(i),1);

        // }
        // return sMap.equals(tMap);

    }
}