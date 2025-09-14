package com.DTJenner.groupnumbers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class NumberRangeSummarizerTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImp();

    @Test
    void testCollectEmptyOrNull() {
        assertTrue(summarizer.collect("").isEmpty());
        assertTrue(summarizer.collect("   ").isEmpty());
        assertTrue(summarizer.collect(null).isEmpty());
    }

    @Test
    void testCollectNormal() {
        assertEquals(List.of(1, 3, 5, 7, 9), summarizer.collect("1,3,5,7,9"));
        assertEquals(List.of(1, 2, 3, 4, 5), summarizer.collect("1,2,3,4,5"));
        assertEquals(List.of(1, 2, 3, 5, 7), summarizer.collect("1,2,3,5,7"));
        assertEquals(List.of(1, 3, 5, 6, 7), summarizer.collect("1,3,5,6,7"));
        assertEquals(List.of(1, 3, 4, 5, 7), summarizer.collect("1,3,4,5,7"));
    }

    @Test
    void testCollectRandom() {
        assertEquals(List.of(1, 3, 6, 7), summarizer.collect(" 1 , 3 , , 6 , 7 "));
        assertEquals(List.of(3, 6), summarizer.collect("  , 3 , , 6 , "));
        assertEquals(List.of(), summarizer.collect("  ,  , ,  ,  "));
    }

    @Test
    void testSummarizeCollectionEmptyOrNull() {
        assertEquals("", summarizer.summarizeCollection(List.of()));
        assertEquals("", summarizer.summarizeCollection(null));
    }

    @Test
    void testSummarizeCollectionNormal() {
        assertEquals("1", summarizer.summarizeCollection(List.of(1)));
        assertEquals("1, 3, 5, 7, 9", summarizer.summarizeCollection(List.of(1, 3, 5, 7, 9)));
        assertEquals("1-5", summarizer.summarizeCollection(List.of(1, 2, 3, 4, 5)));
        assertEquals("1-3, 5, 7", summarizer.summarizeCollection(List.of(1, 2, 3, 5, 7)));
        assertEquals("1, 3, 5-7", summarizer.summarizeCollection(List.of(1, 3, 5, 6, 7)));
        assertEquals("1, 3-5, 7", summarizer.summarizeCollection(List.of(1, 3, 4, 5, 7)));
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summarizer.summarizeCollection(List.of(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31)));
    }
}
