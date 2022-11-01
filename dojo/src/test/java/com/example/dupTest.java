package com.example;

import org.junit.jupiter.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */

public class dupTest {
    @Test
    public void test1()
    {
       Assertions.assertArrayEquals(new Double[] {43.1d, 8.4d}, dup.findSingles(new Double[] {3.14d, 1.25d, 3.14d, 43.1d, 8.4d, 1.25d}));
    }
    @Test
    public void test2()
    {
       Assertions.assertArrayEquals(new Integer[] {1, 2}, dup.findSingles(new Integer[] {2, 4, 5, 4, 5, 1}));
    }
    @Test
    public void test3()
    {
       Assertions.assertArrayEquals(new String[] {"abc", "def"}, dup.findSingles(new String[] {"sdf", "sdf", "ge", "abc", "def", "ge"}));
    }
    @Test
    public void test4()
    {
       Assertions.assertArrayEquals(new Character[] {'a', 'b'}, dup.findSingles(new Character[] {'f', 'd', 'a', 'f', 'd', 'b', 'c', 'c'}));
    }
    @Test
    public void test5()
    {
        Assertions.assertArrayEquals(new Float[] {8.4f, 43.1f}, dup.findSingles(new Float[] {3.14f, 1.25f, 3.14f, 43.1f, 8.4f, 1.25f}));
    }
}
