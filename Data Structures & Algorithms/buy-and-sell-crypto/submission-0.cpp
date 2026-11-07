#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) { 
        int minPrice = INT_MAX;
        int maxPrice = 0;

        for (int price : prices) {
            minPrice = min(minPrice, price);
            maxPrice = max(maxPrice, price - minPrice);
        }
        return maxPrice; 
    }
};
