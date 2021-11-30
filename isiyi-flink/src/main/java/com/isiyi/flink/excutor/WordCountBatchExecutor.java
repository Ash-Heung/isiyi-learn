package com.isiyi.flink.excutor;

import com.isiyi.flink.domain.Tokenizer;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;


/**
 * 统计一个文件的单词出现的总次数，并将结果存储到文件中
 * <p></p>
 *
 * @version 1.0.0
 * @description: WordCountExecutor
 * @author: 向鹏飞
 * @since: 2021/6/6
 */
public class WordCountBatchExecutor {

    public static void main(String[] args) throws Exception {

        String input = "E:\\appdata\\wordcount.txt";
        String output = "E:\\appdata\\out\\wordcount_result.txt";

        //获取Flink运行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> textFile = env.readTextFile(input);

        DataSet<Tuple2<String, Integer>> counts = textFile.flatMap(new Tokenizer()).groupBy(0).sum(1);

        counts.writeAsCsv(output, "\n", "\t").setParallelism(1);

        env.execute("执行了、、、、");
    }


}
