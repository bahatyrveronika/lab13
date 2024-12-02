package ua.edu.ucu.apps.task2;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        Authorization authorization = new Authorization();
        if (authorization.authorize(db)) {
            System.out.println("Authorization successful!");
        } else {
            System.out.println("Authorization failed!");
        }
        ReportBuilder reportBuilder = new ReportBuilder(db);
        String userDataReport = reportBuilder.buildUserDataReport();
        System.out.println("User Data Report: " + userDataReport);
        String statisticsReport = reportBuilder.buildStatisticsReport();
        System.out.println("Statistics Report: " + statisticsReport);
    }
}
