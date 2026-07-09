class Solution {
    public String frequencySort(String s) {
        
        // Can also be done by Bucket sort (most optimal)
        StringBuilder result = new StringBuilder();
        HashMap<Character,Integer> freq = new HashMap<>();
        
        for(int i=0;i<s.length();i++){   
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
        }

        List<Character> lst = new ArrayList<>(freq.keySet());
        lst.sort((ch1,ch2) -> Integer.compare(freq.get(ch2), freq.get(ch1)));

        for(char ch: lst){
            for(int i=0;i<freq.get(ch);i++){
                result.append(ch);
            }
        }
        return result.toString();

    }
}