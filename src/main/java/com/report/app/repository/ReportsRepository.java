package com.report.app.repository;

import com.report.app.models.ReportGeneral;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReportsRepository extends ReactiveMongoRepository<ReportGeneral, String> {
}
