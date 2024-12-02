package ua.edu.ucu.apps.task3;

import java.io.IOException;

public class ExtractInfo {

    public static void main(String[] args) throws IOException {
        CompanyInfoFacade facade = new CompanyInfoFacade();
        Company company = facade.getCompanyInfo("ucu.edu.ua");
        System.out.println(company);
    }
}
