/*
* Seats.java
*
* ENSF 480 Term Project
* Fall 2022
* L01 Group 2
* Authors: Sobia Khan, Ana Clara Perrone, Maitry Rohit, Christina Wyllie
*
*/

public class Seats {
    /*
     * Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(now);
     */

    public ArrayList<LocalTime> getMovTimes(String title, String theatreName, LocalDate date)
    {
        ArrayList<LocalTime> showtime = new ArrayList<LocalTime>();
        java.sql.Date myDate = java.sql.Date.valueOf(date);

        try
        {
            Statement s = this.connect.createStatement();
            String query = "SELECT movTime FROM SHOWING WHERE loc = '" + theatreName + "' AND movDate = '" + myDate + "' AND title = '" + title + "';";
            ResultSet results = s.executeQuery(query);

            while(results.next())
            {
                LocalTime time = results.getObject("movTime", LocalTime.class);
                showtime.add(time);
            } 

            results.close();
            return showtime;
                
        }

        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return showtime;
    }

}
