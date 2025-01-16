class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> heap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            heap.put(tasks[i], heap.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (b, a) -> {
                    return Integer.compare(a, b);
                });

        for (Map.Entry<Character, Integer> entry : heap.entrySet()) {
            int val = entry.getValue();
            pq.add(val);
        }

        int ans = 0;

        while (pq.size() > 0) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                if (pq.size() > 0) {
                    int ele = pq.peek();
                    pq.poll();
                    temp.add(ele - 1);
                }
            }

            for(int i=0;i<temp.size();i++){
                if(temp.get(i)!=0){
                    pq.add(temp.get(i));
                }
            }
            if (pq.size() == 0) {
                ans += temp.size();
            } else {
                ans += n + 1;
            }
        }
        return ans;
    }
}
