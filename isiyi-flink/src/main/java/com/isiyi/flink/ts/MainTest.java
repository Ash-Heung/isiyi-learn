package com.isiyi.flink.ts;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.Test;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: MainTest
 * @author: 向鹏飞
 * @since: 2021/6/20
 */
public class MainTest {

    @Test
    public void main() throws Exception {
       // ExecutionEnvironment environment = ExecutionEnvironment.getExecutionEnvironment();
       // TsOperatorTest.mapFunction(environment);
        //TsOperatorTest.firstFunction(environment);
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        //StreamOperatorTest.filterFunction(environment);
        StreamOperatorTest.unionFunction(environment);
        environment.execute("");
    }

}
