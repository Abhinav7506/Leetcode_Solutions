class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum=0;
        for(int l=0;l<nums.size();l++){
            int distinct=0;
            Set<Integer> used = new HashSet<>();
            
            for (int r = l; r < nums.size(); r++) { 
                if (!used.contains(nums.get(r))) { 
                    distinct++;
                }

                used.add(nums.get(r)); 
                sum += distinct * distinct;
            }
        }
        return sum;
    }
}