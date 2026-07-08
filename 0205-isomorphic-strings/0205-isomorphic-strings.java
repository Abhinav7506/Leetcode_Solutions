class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> comp = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(comp.containsKey(s.charAt(i))){
                if ((comp.get(s.charAt(i)))!=t.charAt(i))
                    return false;
            }
            else{
                if(used.contains(t.charAt(i))) return false;    
                comp.put(s.charAt(i),t.charAt(i));
                used.add(t.charAt(i));
                }
        }
        return true;
    }
}