package com.since.sincethird.service.impl;

import com.since.sincethird.repository.ReportRepository;
import com.since.sincethird.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepository reportRepository;
}
