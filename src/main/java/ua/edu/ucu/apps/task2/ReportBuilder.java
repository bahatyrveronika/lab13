package ua.edu.ucu.apps.task2;

public class ReportBuilder {
    private DB db;

    public ReportBuilder(DB db) {
        this.db = db;
    }
    public String buildUserDataReport() {
        return db.getUserData();
    }

    public String buildStatisticsReport() {
        return db.getStatisticsData();
    }
}