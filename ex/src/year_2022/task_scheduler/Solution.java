package year_2022.task_scheduler;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    private static final Character END_CHAR = 'a';

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Long> frequencies = String.valueOf(tasks).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> idleTimeCounter = frequencies.keySet().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int timeNeeded = 0;
        while (true) {
            Set<Character> jobsWithMinimalIdleTime = findJobsWithMinimalIdleTime(idleTimeCounter);
            if (jobsWithMinimalIdleTime.isEmpty()) {
                decreaseCounters(idleTimeCounter);
                continue;
            } else  {
                Character mostFrequent = findTheMostFrequent(frequencies, jobsWithMinimalIdleTime);
                if (mostFrequent == END_CHAR) {
                    break;
                }
            }

            timeNeeded++;
        }

        return timeNeeded;
    }

    private void decreaseCounters(Map<Character, Long> idleTimeCounter) {
        idleTimeCounter.forEach((key, value) -> idleTimeCounter.put(key, value - 1));
    }

    private Set<Character> findJobsWithMinimalIdleTime(Map<Character, Long> idleTimeCounter) {
        Long minIdleTime = idleTimeCounter.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(Long.MAX_VALUE);

        if (minIdleTime > 0) {
            return Set.of();
        }

        return idleTimeCounter.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), minIdleTime))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    private Character findTheMostFrequent(Map<Character, Long> frequencies, Set<Character> jobsWithMinimalIdleTime) {
        return frequencies.entrySet()
                .stream()
                .filter(entry -> jobsWithMinimalIdleTime.contains(entry.getKey()))
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(END_CHAR);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
        System.out.println(solution.leastInterval(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));

    }

}
