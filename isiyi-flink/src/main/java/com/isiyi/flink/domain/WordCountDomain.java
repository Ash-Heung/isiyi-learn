package com.isiyi.flink.domain;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: WordCountDomain
 * @author: 向鹏飞
 * @since: 2021/6/6
 */
public class WordCountDomain {
    private String word;
    private long count;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public WordCountDomain(String word, long count) {
        this.word = word;
        this.count = count;
    }

    public WordCountDomain() {
    }

    @Override
    public String toString() {
        return "WordCountDomain{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
