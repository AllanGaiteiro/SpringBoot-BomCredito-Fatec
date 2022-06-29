package br.com.allangaiteiro.bomcredito.model.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.allangaiteiro.bomcredito.model.RequestDay;

public class DashboardMonth {
    public String title;
    public List<Integer> listDays;
    public List<Integer> listValue;

    public DashboardMonth(String title,  List<RequestDay> requestDays) {
        this.title = title;
        this.setDaysAndValue(requestDays);
    }

    private void setDaysAndValue( List<RequestDay> requestDays) {
        List<Integer> listDays = new ArrayList<>();
        List<Integer> listValue = new ArrayList<>();
        for (RequestDay requestDay : requestDays) {
            listDays.add(requestDay.getDia());
            listValue.add(requestDay.getTotal());
        }
        List<Integer> listDaysFormat = new ArrayList();
        List<Integer> listValueFormat = new ArrayList();

        Integer date = new Date().getDate();
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
