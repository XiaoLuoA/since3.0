package com.since.sincethird.task;

import com.since.sincethird.common.Status;
import com.since.sincethird.entity.WXList;
import com.since.sincethird.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchedulerTask {

    @Autowired
    ListRepository listRepository;


    @Scheduled(cron = "0 */30 * * * ?")
    public void findAllByWxListStatus() {
        List<WXList> wxLists = listRepository.findAllByStatus(Status.WX_LIST_NOT_PAY);
        System.out.println(wxLists);
        for (WXList wxList : wxLists) {
            long listTime = Long.parseLong((String.valueOf(wxList.getNo()).substring(0, 13)));
            long nowTime = System.currentTimeMillis();
            //间隔时间
            long intervalTime = Long.parseLong(String.valueOf(30 * 60 * 1000));
            long time = nowTime - listTime;
            if (time >= intervalTime) {
                listRepository.updateStatus(wxList.getNo(), Status.WX_LIST_DELETE);
            }
        }
    }
}
