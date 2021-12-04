package com.isiyi.flink.source;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

/**
 * 自定义source
 * <p></p>
 *
 * @version 1.0.0
 * @description: MySourceFunction
 * @author: 向鹏飞
 * @since: 2021/12/4
 */
public class MySourceFunction implements SourceFunction<String> {



    @Override
    public void run(SourceContext<String> ctx) throws Exception {

    }


    @Override
    public void cancel() {

    }
}
