package com.since.sincethird.common;

/**
 * @author 王英豪111
 */
public interface Status {
     Integer WXLIST_PAY = 2;
     Integer WX_LIST_NOT_PAY = 1;
     Integer WX_LIST_DELETE = -1;
     Integer WXLIST_PAY_FAIL = 0;

     Integer NORMAL = 1;
     Integer NOT_NORMAL = 0;
     Integer BOOK_EMPTY = 2;

     String SUCCESS = "SUCCESS";
     String FAIL = "FAIL";
}
