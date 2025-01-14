class MedianFinder {

     PriorityQueue<Integer>maxHeap = new PriorityQueue<>(
            (a,b)->{
                return Integer.compare(b,a);
    });

    PriorityQueue<Integer>minHeap = new PriorityQueue<>(
            (a,b)->{
                return Integer.compare(a, b);
    });
    

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {

         if(maxHeap.size()==0){
                maxHeap.add(num);
            }
            else{
                int top = maxHeap.peek();
                if(num>top){
                    minHeap.add(num);
                }
                else{
                    maxHeap.add(num);
                }
            }
            if(maxHeap.size()-1 > minHeap.size()){
                int top = maxHeap.poll();
                minHeap.add(top);
            }
            else if(minHeap.size()>maxHeap.size()){
                int top = minHeap.poll();
                maxHeap.add(top);
            }
        
    }
    
    public double findMedian() {
        double tempAns = 0.00000;
        if(maxHeap.size()==minHeap.size()){
             tempAns = (double)(maxHeap.peek() + minHeap.peek())/2;
        }
        else{
            tempAns=maxHeap.peek();
        }
        return tempAns;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
