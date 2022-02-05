package stock_buy_sell_to_maximize_profit;

import static java.lang.String.format;

public class Solution {

    public static Tuple<Integer, Integer> findBuySellStockPrices(int[] array) {
        int current_buy = array[0];
        int current_sell = array[1];

        int global_profit = current_sell - current_buy;
        int curren_profit;

        for (int i = 1; i < array.length; i++) {
            curren_profit = array[i] - current_buy;
            if (curren_profit > global_profit) {
                global_profit = curren_profit;
                current_sell = array[i];
            }

            if (array[i] < current_buy) {
                current_buy = array[i];
            }
        }

        return new Tuple<>(global_profit - current_sell, current_sell);
    }

    private static class Tuple<X, Y> {
        public X x;
        public Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return format("(%d: %d)", x, y);
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 0, 2};
        Tuple<Integer, Integer> result = findBuySellStockPrices(array);
        System.out.println(result);
    }

}
