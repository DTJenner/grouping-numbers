package com.DTJenner.groupnumbers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizerImp implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().equals("")) {
            return Collections.emptyList();
        }

        List<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(",");

        for (String part : parts) {
            String trimmed = part.trim();

            if (!trimmed.equals("")) {
                int num = Integer.parseInt(trimmed);
                numbers.add(num);
            }
        }

        //Collections.sort(numbers);  ->  ASSUMPTION: input is always in sorted in ascending order (if not, uncomment this line)
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        List<Integer> numbers = new ArrayList<>(input);
        //List<Integer> numbers = new ArrayList<>(new TreeSet<>(input));  ->  ASSUMPTION: input doesn't contain duplicate numbers (if so, uncomment this line and comment out the line above)
        StringBuilder sb = new StringBuilder();

        int start = numbers.get(0);
        int prev = start;

        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);

            if (current != prev + 1) {
                appendNums(sb, start, prev);
                start = current;
            }
            prev = current;
        }

        appendNums(sb, start, prev);
        return sb.toString();
    }

    private void appendNums(StringBuilder sb, int start, int end) {
        if (sb.length() > 0) {
            sb.append(", ");
        }

        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start).append("-").append(end);
        }
    }
}
