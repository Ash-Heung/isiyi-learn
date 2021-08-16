package com.isiyi.pattern.pipeline;

import com.isiyi.pattern.pipeline.entity.InstanceBuildContext;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: ModelInstanceCreator
 * @author: 向鹏飞
 * @since: 2021/7/30
 */
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {




    @Override
    public boolean handle(InstanceBuildContext context) {
        System.out.println("--根据输入数据创建模型实例--");


        // 假装创建模型实例


        return true;
    }
}
