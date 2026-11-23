class ProductOfNumbers {
    ArrayList<Integer> arr = new ArrayList<>();
    
    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        arr.add(num);
    }
    
    public int getProduct(int k) {
        int prod = 1;
        int i = 0;
        while(k>i){
            prod *= arr.get(arr.size()- 1 - i++);
        }
        return prod;

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */