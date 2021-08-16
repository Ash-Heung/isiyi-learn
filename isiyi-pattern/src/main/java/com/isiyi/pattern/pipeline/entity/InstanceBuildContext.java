package com.isiyi.pattern.pipeline.entity;

import com.isiyi.pattern.pipeline.entity.PipelineContext;
import lombok.Data;

import java.util.Map;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: InstanceBuildContext
 * @author: 向鹏飞
 * @since: 2021/7/30
 */
@Data
public class InstanceBuildContext extends PipelineContext {


    /**
     * 模型 id
     */
    private Long modelId;


    /**
     * 用户 id
     */
    private long userId;


    /**
     * 表单输入
     */
    private Map<String, Object> formInput;


    /**
     * 保存模型实例完成后，记录下 id
     */
    private Long instanceId;


    /**
     * 模型创建出错时的错误信息
     */
    private String errorMsg;


    // 其他参数


    @Override
    public String getName() {
        return "模型实例构建上下文";
    }
}
