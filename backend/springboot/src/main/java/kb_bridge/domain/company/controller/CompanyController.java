package kb_bridge.domain.company.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kb_bridge.domain.company.service.CompanyService;
import kb_bridge.external.dart.dto.DartCompanyResponse;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{corpCode}")
    public DartCompanyResponse getCompany(
            @PathVariable String corpCode
    ) {
        return companyService.getCompany(corpCode);
    }
}