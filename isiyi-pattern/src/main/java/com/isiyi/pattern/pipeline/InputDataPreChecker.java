package com.isiyi.pattern.pipeline;

import com.isiyi.pattern.pipeline.entity.InstanceBuildContext;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: InputDataPreChecker
 * @author: 向鹏飞
 * @since: 2021/7/30
 */
public class InputDataPreChecker implements ContextHandler<InstanceBuildContext> {


    @Override
    public boolean handle(InstanceBuildContext context) {
        System.out.println("--输入数据校验--");


        Map<String, Object> formInput = context.getFormInput();


        if (MapUtils.isEmpty(formInput)) {
            context.setErrorMsg("表单输入数据不能为空");
            return false;
        }


        String instanceName = (String) formInput.get("instanceName");


        if (StringUtils.isBlank(instanceName)) {
            context.setErrorMsg("表单输入数据必须包含实例名称");
            return false;
        }


        return true;
    }
}
