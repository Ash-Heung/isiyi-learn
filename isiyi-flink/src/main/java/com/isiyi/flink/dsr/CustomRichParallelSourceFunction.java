package com.isiyi.flink.dsr;

import org.apache.flink.streaming.api.functions.source.ParallelSourceFunction;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: CustomNonParallelSourceFuncation
 * @author: 向鹏飞
 * @since: 2021/6/21
 */
public class CustomRichParallelSourceFunction extends RichSourceFunction<Long> {
    private long COUNT = 1L;
    boolean RUNNING = true;
    @Override
    public void run(SourceContext<Long> sourceContext) throws Exception {
        while (RUNNING){
            sourceContext.collect(COUNT);
            COUNT ++;
            Thread.sleep(1000);
        }
    }

    @Override
    public void cancel() {
        RUNNING = false;
    }
}
