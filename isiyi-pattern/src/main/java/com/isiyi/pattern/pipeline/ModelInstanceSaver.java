package com.isiyi.pattern.pipeline;

import com.isiyi.pattern.pipeline.entity.InstanceBuildContext;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: ModelInstanceSaver
 * @author: 向鹏飞
 * @since: 2021/7/30
 */
public class ModelInstanceSaver implements ContextHandler<InstanceBuildContext> {


    @Override
    public boolean handle(InstanceBuildContext context) {
        System.out.println("--保存模型实例到相关DB表--");


        // 假装保存模型实例


        return true;
    }
}
