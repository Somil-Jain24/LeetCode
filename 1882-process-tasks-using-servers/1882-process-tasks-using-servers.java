import java.util.PriorityQueue;

class Solution {
    // Helper class to encapsulate server properties
    static class Server {
        int weight;
        int index;
        long freeTime;

        Server(int weight, int index) {
            this.weight = weight;
            this.index = index;
            this.freeTime = 0;
        }

        Server(int weight, int index, long freeTime) {
            this.weight = weight;
            this.index = index;
            this.freeTime = freeTime;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        // available: sorted by weight ASC, then index ASC
        PriorityQueue<Server> available = new PriorityQueue<>((a, b) -> {
            if (a.weight != b.weight) {
                return Integer.compare(a.weight, b.weight);
            }
            return Integer.compare(a.index, b.index);
        });

        // busy: sorted by freeTime ASC, then weight ASC, then index ASC
        PriorityQueue<Server> busy = new PriorityQueue<>((a, b) -> {
            if (a.freeTime != b.freeTime) {
                return Long.compare(a.freeTime, b.freeTime);
            }
            if (a.weight != b.weight) {
                return Integer.compare(a.weight, b.weight);
            }
            return Integer.compare(a.index, b.index);
        });

        // Initialize available servers
        for (int i = 0; i < n; i++) {
            available.offer(new Server(servers[i], i));
        }

        int[] ans = new int[m];
        long currentTime = 0;

        for (int j = 0; j < m; j++) {
            // Task j is ready at second j
            currentTime = Math.max(currentTime, (long) j);

            // If no servers are available, jump time directly to the earliest completion
            if (available.isEmpty()) {
                currentTime = busy.peek().freeTime;
            }

            // Release all servers whose tasks are finished by currentTime
            while (!busy.isEmpty() && busy.peek().freeTime <= currentTime) {
                Server freed = busy.poll();
                available.offer(freed);
            }

            // Pick the best available server
            Server chosen = available.poll();
            ans[j] = chosen.index;

            // Mark server as busy until currentTime + tasks[j]
            chosen.freeTime = currentTime + tasks[j];
            busy.offer(chosen);
        }

        return ans;
    }
}