class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();

      for (String w : words){
        for(char c : w.toCharArray()) {
            adj.putIfAbsent(c, new HashSet<>());
            indegree.putIfAbsent(c, 0);
        }
      }

      for (int i = 0; i < words.length - 1; i++) {
        String w1 = words[i], w2 = words[i + 1];
        int minLen = Math.min(w1.length(), w2.length());

        if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

        for (int j = 0; j < minLen; j++) {
            char a = w1.charAt(j), b = w2.charAt(j);
            if (a != b) {
                if (adj.get(a).add(b)) {
                        indegree.put(b, indegree.get(b) + 1);
                }
                break;
            }
        }
      }

      Queue <Character> queue = new ArrayDeque<>();
      for (char c : indegree.keySet()) {
        if (indegree.get(c) == 0) queue.add(c);
      }

      StringBuilder result = new StringBuilder();
      while (!queue.isEmpty()) {
        char c = queue.poll();
        result.append(c);
        for (char next : adj.get(c)) {
            indegree.put(next, indegree.get(next) - 1);
            if (indegree.get(next) == 0) queue.add(next);
        }

      }

      return result.length() == adj.size() ? result.toString() : "";

    }
}
