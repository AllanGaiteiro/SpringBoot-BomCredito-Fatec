package br.com.allangaiteiro.bomcredito.model.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DashboardMonth {
    public String title;
    public List<Integer> listDays;
    public List<Integer> listValue;

    public DashboardMonth(String title, List<Integer> listDays, List<Integer> listValue) {
        this.title = title;
        this.setDaysAndValue(listDays, listValue);
    }

    private void setDaysAndValue(List<Integer> listDays, List<Integer> listValue) {
        List<Integer> listDaysFormat = new ArrayList();
        List<Integer> listValueFormat = new ArrayList();

        Integer date = new Date().getDate();
        Integer max = listDays.get(0);
        listDays.sort((a, b) -> a - b);
        for (int i = 1; i <= date; i++) {
            Integer dayIndex = listDays.indexOf(i) ;
            listValueFormat.add(dayIndex >= 0 ? listValue.get(dayIndex) : 0);
            listDaysFormat.add(i);
        }
        this.listDays = listDaysFormat;
        this.listValue = listValueFormat;
    }

    @Override
    public String toString() {
        return "{listDays:" + listDays + ", listValue:" + listValue + ", title:" + title + "}";
    }

}
