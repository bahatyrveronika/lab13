package ua.edu.ucu.apps.task3;

import java.io.IOException;

public class CompanyInfoFacade {

    private final ChatGPTReader chatGPTReader;

    public CompanyInfoFacade() {
        this.chatGPTReader = new ChatGPTReader();
    }
    public Company getCompanyInfo(String linkSite) throws IOException {
        Company company = new Company();
        company.name = chatGPTReader.getSummary("Provide just the name of the company for the website: " + linkSite);
        company.description = chatGPTReader.getSummary("Provide a short description for the company at: " + linkSite);
        if (company.name == null || company.name.trim().isEmpty()) {
            company.name = "Company name not found";
        }
        if (company.description == null || company.description.trim().isEmpty()) {
            company.description = "Description not available";
        }
        company.logoLink = "Placeholder for logo (add implementation if needed)";
        return company;
    }

}
