package controller;

import service.DashboardService;
import view.Display;

public class DashboardController {

    private DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public void showDashboard() {
        Display.showDashboard(dashboardService);
    }
}
