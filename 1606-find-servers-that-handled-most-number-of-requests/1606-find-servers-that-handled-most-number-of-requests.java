import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Track the count of requests handled by each server
        int[] count = new int[k];
        
        // Min-heap to store busy servers: [endTime, serverId]
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // TreeSet to store currently available server IDs
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        
        int n = arrival.length;
        for (int i = 0; i < n; i++) {
            int time = arrival[i];
            int duration = load[i];
            
            // Free all servers that have finished before or at current arrival time
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.add(busy.poll()[1]);
            }
            
            // If no servers are available, the request is dropped
            if (available.isEmpty()) {
                continue;
            }
            
            // Find the first available server >= (i % k)
            Integer server = available.ceiling(i % k);
            if (server == null) {
                // Wrap around to the start
                server = available.first();
            }
            
            // Assign the request to this server
            available.remove(server);
            busy.offer(new int[]{time + duration, server});
            count[server]++;
        }
        
        // Find the maximum number of requests handled
        int maxRequests = 0;
        for (int c : count) {
            maxRequests = Math.max(maxRequests, c);
        }
        
        // Collect all servers that handled maxRequests
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}