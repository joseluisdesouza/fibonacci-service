package com.api.fibonacciapi.service;

import com.api.fibonacciapi.domain.FibonacciNumber;
import com.api.fibonacciapi.exception.FibonacciIndexOutOfBoundsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {

    public List<Integer> sequenceToN(int n) {
        if (n < 0) throw new IllegalArgumentException();

        List<Integer> sequence = new ArrayList<>(n);

        int prev = 0;
        int next = 1;
        while (sequence.size() < n) {
            sequence.add(next);
            int sum = prev + next;
            prev = next;
            next = sum;
        }
        return sequence;
    }

    public FibonacciNumber calculateFibonacci(int fibonacciIndex) throws FibonacciIndexOutOfBoundsException {
        if (fibonacciIndex < 0 || fibonacciIndex > 75) {
            throw new FibonacciIndexOutOfBoundsException("Cannot be less than 0 or greater than 75");
        }

        FibonacciNumber fibonacciNumber = new FibonacciNumber();

        if (fibonacciIndex <= 1) {
            fibonacciNumber.setFibonacciValue(fibonacciIndex);
            fibonacciNumber.setFibonacciIndex(fibonacciIndex);
            return fibonacciNumber;
        }

        long[] fibNums = new long[fibonacciIndex + 1];
        fibNums[0] = 0;
        fibNums[1] = 1;
        for (int index = 2; index <= fibonacciIndex; index++) {
            fibNums[index] = fibNums[index - 1] + fibNums[index - 2];
        }

        fibonacciNumber.setFibonacciValue(fibNums[fibonacciIndex]);
        fibonacciNumber.setFibonacciIndex(fibonacciIndex);

        return fibonacciNumber;
    }
}
