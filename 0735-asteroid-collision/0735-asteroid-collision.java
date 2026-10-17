class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> st = new ArrayList<>();
        for(int num: asteroids){
            if(num>0){
                st.add(num);
            }
            else{
                int currentSize = Math.abs(num);
                boolean destroyed = false;

                while(!st.isEmpty() && st.get(st.size() - 1) > 0){
                    int topIndex = st.size() - 1;
                    int topSize = Math.abs(st.get(topIndex));
                    
                    if (topSize < currentSize) {
                        st.remove(topIndex);
                    } 
                    else{
                        if (topSize == currentSize) {
                            st.remove(topIndex);
                        }
                        destroyed = true;
                        break;
                    }
                    
                }
            if (!destroyed) {
                    st.add(num);
                }
        }
        }
        int[] answer = new int[st.size()];
 
        for (int index = 0; index < st.size(); index++) {
            answer[index] = st.get(index);
        }
 
        return answer;
    }
}