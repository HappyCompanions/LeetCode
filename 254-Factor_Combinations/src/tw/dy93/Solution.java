package tw.dy93;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dy93 on 2017/3/7.
 */
public class Solution {
    private Map<Integer, List<List<Integer>>> cache;

    public Solution() {
        cache = new HashMap<>();
    }

    public List<List<Integer>> getFactors(int n) {
        List<Integer> factors = getAllFactors(n);

        List<List<Integer>> answers = factorCombinations(n, factors);
        answers.remove(answers.size() - 1);

        return answers;
    }

    private List<List<Integer>> factorCombinations(int n, List<Integer> factors) {
        if (cache.get(n) != null) {
            return cache.get(n);
        } else {
            List<List<Integer>> answers = new ArrayList<>();
            for (final Integer factor : factors) {
                if (n % factor == 0 && factor <= n / factor) {
                    List<List<Integer>> subAnswers = factorCombinations(n / factor, factors);
                    subAnswers = subAnswers.stream()
                            .filter(list -> factor <= ((LinkedList<Integer>) list).getFirst())
                            .map(list -> {
                                LinkedList<Integer> newList = new LinkedList<>(list);
                                newList.addFirst(factor);
                                return newList;
                            })
                            .collect(Collectors.toList());
                    answers.addAll(subAnswers);
                }
            }

            // add n
            LinkedList<Integer> subAns = new LinkedList<>();
            subAns.add(n);
            answers.add(subAns);
            cache.put(n, answers);
            return answers;
        }
    }

    private List<Integer> getAllFactors(int n) {
        double sqrt = Math.sqrt(n);

        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }

        for (int i = factors.size() - 1; i >= 0; i--) {
            if (n / factors.get(i) != factors.get(i)) {
                factors.add(n / factors.get(i));
            }
        }

        return factors;
    }
}