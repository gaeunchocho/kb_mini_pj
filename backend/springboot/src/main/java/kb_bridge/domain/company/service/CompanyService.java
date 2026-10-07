package kb_bridge.domain.company.service;

import org.springframework.stereotype.Service;

import kb_bridge.external.dart.DartClient;
import kb_bridge.external.dart.dto.DartCompanyResponse;

@Service
public class CompanyService {

    private final DartClient dartClient;

    public CompanyService(DartClient dartClient) {
        this.dartClient = dartClient;
    }

    public DartCompanyResponse getCompany(String corpCode) {
        return dartClient.getCompany(corpCode);
    }
}