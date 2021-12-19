package com.isiyi.flink.source;

import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileChecksum;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
    private String md5 = null;
    private Boolean isCancel = true;
    private Integer interval = 10000;


    @Override
    public void run(SourceContext<String> ctx) throws Exception {

        Path pathString = new Path("hdfs://ns1/user/qingniu/country_data");
        Configuration hadoopConf = new Configuration();
        FileSystem fs = FileSystem.get(hadoopConf);
        while (isCancel) {
            if (!fs.exists(pathString)) {
                Thread.sleep(interval);
                continue;
            }
            FileChecksum fileChecksum = fs.getFileChecksum(pathString);
            String md5Str = fileChecksum.toString();
            String currentMd5 = md5Str.substring(md5Str.indexOf(":") + 1);
            if (!currentMd5.equals(md5)) {
                FSDataInputStream open = fs.open(pathString);
                BufferedReader reader = new BufferedReader(new InputStreamReader(open));
                String line = reader.readLine();
                while (line != null) {
                    ctx.collect(line);
                    line = reader.readLine();
                }
                reader.close();
                md5 = currentMd5;
            }
            Thread.sleep(interval);
        }
    }


    @Override
    public void cancel() {
        isCancel = false;
    }
}
