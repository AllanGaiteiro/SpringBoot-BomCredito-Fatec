package br.com.allangaiteiro.bomcredito.model;

public class Metric {
    private long total;
    private long day;
    private long beforeDay;
    private long month;
    private long beforeMonth;
    private long percentDay;
    private long percentMonth;

    public Metric(long total, long day, long beforeDay, long month, long beforeMonth) {
        this.total = total;
        this.day = day;
        this.beforeDay = beforeDay;
        this.month = month;
        this.beforeMonth = beforeMonth;
        this.setPercentDay();
        this.setPercentMonth();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public long getBeforeDay() {
        return beforeDay;
    }

    public void setBeforeDay(long beforeDay) {
        this.beforeDay = beforeDay;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public long getBeforeMonth() {
        return beforeMonth;
    }

    public void setBeforeMonth(long beforeMonth) {
        this.beforeMonth = beforeMonth;
    }

    public long getPercentDay() {
        return percentDay;
    }
    public String getPercentDayString() {
        return Long.toString(percentDay) + '%';
    }

    private void setPercentDay() {
        this.percentDay = this.beforeDay == 0 ? 100 :((this.day / this.beforeDay) - 1) * 100;
    }

    public long getPercentMonth() {
        return percentMonth;
    }
    public String getPercentMonthString() {
        return Long.toString(percentMonth) + '%';
    }

    private void setPercentMonth() {
        this.percentMonth = this.beforeMonth == 0 ? 100 :((this.month / this.beforeMonth) - 1) * 100;
    }

    @Override
    public String toString() {
        return "Metric [beforeDay=" + beforeDay + ", beforeMonth=" + beforeMonth + ", day=" + day + ", month=" + month
                + ", percentDay=" + percentDay + ", percentMonth=" + percentMonth + ", total=" + total + "]";
    }

}
