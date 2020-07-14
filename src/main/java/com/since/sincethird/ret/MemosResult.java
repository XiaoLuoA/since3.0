package com.since.sincethird.ret;

/**
 * @author jayzh
 */
public interface MemosResult extends Result{
    Code MEMOS_OBJ_IS_NULL=new Code("700_001","后台未接收到留言对象");
    Code MEMOS_MESSAGE_IS_NULL=new Code("700_002","后台未接收到留言内容");
    Code MEMOS_GET_IS_NULL= new Code("700_003","从数据库中获取数据集为零");
    Code MEMOS_NOT_EXIT=new Code("700_004","数据路中不存在改留言");
    Code MEMOS_ID_GET_FAIL=new Code("700_005","留言ID不合法");
}
