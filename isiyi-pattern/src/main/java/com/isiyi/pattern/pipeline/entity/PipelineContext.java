package com.isiyi.pattern.pipeline.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: PipelineContext
 * @author: 向鹏飞
 * @since: 2021/7/30
 */
@Data
public class PipelineContext {

    /**
     * 处理开始时间
     */
    private LocalDateTime startTime;


    /**
     * 处理结束时间
     */
    private LocalDateTime endTime;


    /**
     * 获取数据名称
     */
    public String getName() {
        return this.getClass().getSimpleName();
    }

}
