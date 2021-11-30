package com.isiyi.flink.domain;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.api.java.tuple.Tuple2;
/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: Tokenizer
 * @author: 向鹏飞
 * @since: 2021/6/6
 */
public class Tokenizer implements FlatMapFunction<String, Tuple2<String, Integer>> {
    @Override
    public void flatMap(String value, Collector<Tuple2<String, Integer>> collector) throws Exception {

        String[] tokens = value.toLowerCase().split("\t");
        for (String token : tokens) {

            if (token.length() > 0) {
                collector.collect(new Tuple2<>(token, 1));
            }
        }
    }
}
