package com.since.sincethird.common;

/**
 * @author luoxinyuan
 */
public interface Status {
     Integer WX_LIST_PAY_SEND = 3;
     Integer WX_LIST_PAY = 2;
     Integer WX_LIST_NOT_PAY = 1;
     Integer WX_LIST_DELETE = -1;
     Integer WX_LIST_PAY_FAIL = 0;


     Integer NORMAL = 1;
     Integer BOOK_EMPTY = 2;

     String SUCCESS = "SUCCESS";
     String FAIL = "FAIL";
     /**
      * @author jayzh
      */
     String COMPARE_CODE="oIaLN56oDznSc0iUoec1ZYuWu8G8";
}
