package controller;

import service.DashboardService;
import view.Display;

import java.util.Scanner;

public class DashboardController {

    private DashboardService dashboardService;
    Scanner scan = new Scanner(System.in);

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    // CHAMA DISPLAY DO DASHBOARD
    public void showDashboard() {
        Display.showDashboard(scan, dashboardService);
    }
}
