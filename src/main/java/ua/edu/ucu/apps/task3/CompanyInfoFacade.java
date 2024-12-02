package ua.edu.ucu.apps.task3;

import java.io.IOException;

public class CompanyInfoFacade {

    private final PDLReader pdlReader;
    private final BrandfetchReader brandfetchReader;
    private final WebScraper webScraper;
    private final ChatGPTReader chatGPTReader;

    public CompanyInfoFacade() {
        this.pdlReader = new PDLReader();
        this.brandfetchReader = new BrandfetchReader();
        this.webScraper = new WebScraper();
        this.chatGPTReader = new ChatGPTReader();
    }

    public Company getCompanyInfo(String linkSite) throws IOException {
        Company company = new Company();

        // PDL API
        company.name = pdlReader.getCompanyName(linkSite);
        company.description = pdlReader.getCompanyDescription(linkSite);

        // Brandfetch API
        company.logoLink = brandfetchReader.getLogo(linkSite);

        // Web scraping
        String extraInfo = webScraper.getAdditionalInfo(linkSite);

        // ChatGPT
        String prompt = "Provide a brief summary for the company: " + company.name
                + ". Here is the description: " + company.description
                + (extraInfo != null ? " Additional information: " + extraInfo : "");
        String chatGPTDescription = chatGPTReader.getSummary(prompt);

        // Оновлюємо опис компанії
        company.description += "\n\nChatGPT Summary:\n" + chatGPTDescription;

        return company;
    }
}
