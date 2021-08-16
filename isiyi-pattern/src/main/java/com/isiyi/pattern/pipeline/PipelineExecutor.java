package com.isiyi.pattern.pipeline;

import com.isiyi.pattern.pipeline.entity.PipelineContext;
import org.apache.commons.collections.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: PipelineExecutor
 * @author: 向鹏飞
 * @since: 2021/7/30
 */
public class PipelineExecutor {



    /**
     * 引用 PipelineRouteConfig 中的 pipelineRouteMap
     */
    @Resource
    private Map<Class<? extends PipelineContext>,
                List<? extends ContextHandler<? super PipelineContext>>> pipelineRouteMap;


    /**
     * 同步处理输入的上下文数据<br/>
     * 如果处理时上下文数据流通到最后一个处理器且最后一个处理器返回 true，则返回 true，否则返回 false
     *
     * @param context 输入的上下文数据
     * @return 处理过程中管道是否畅通，畅通返回 true，不畅通返回 false
     */
    public boolean acceptSync(PipelineContext context) {
        Objects.requireNonNull(context, "上下文数据不能为 null");
        // 拿到数据类型
        Class<? extends PipelineContext> dataType = context.getClass();
        // 获取数据处理管道
        List<? extends ContextHandler<? super PipelineContext>> pipeline = pipelineRouteMap.get(dataType);


        if (CollectionUtils.isEmpty(pipeline)) {
            System.out.println(dataType.getSimpleName() + " 的管道为空" );
            return false;
        }


        // 管道是否畅通
        boolean lastSuccess = true;


        for (ContextHandler<? super PipelineContext> handler : pipeline) {
            try {
                // 当前处理器处理数据，并返回是否继续向下处理
                lastSuccess = handler.handle(context);
            } catch (Throwable ex) {
                lastSuccess = false;
               ex.printStackTrace();
            }


            // 不再向下处理
            if (!lastSuccess) { break; }
        }


        return lastSuccess;
    }

}
