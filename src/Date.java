public class Date {
    private String date;
    private String dayOfWeek;

    public void Date(String date){
        this.date = date;
        ///this.dayOfWeek

    }

    public String getDate() {
        return date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return date;
    }
}
