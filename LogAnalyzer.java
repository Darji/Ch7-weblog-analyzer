/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
  
    
    // added in the val of the total
    public int numberOfAccesses()
    {
            int total = 0;
            for(int hour = 0; hour < hourCounts.length; hour++) {
            total = total + hourCounts[hour];
            }// end of for
            return total;
    }// end if numberOfAccessess
    //use while
    public int busiestHour()
    {
            int numberOfAccessesAtBusiest = 0;
            int busiestHour = 0;
            int index = 0;
            while(index < hourCounts.length - 1){
                if (numberOfAccessesAtBusiest < hourCounts[index]){
                    busiestHour = index;
                    numberOfAccessesAtBusiest = hourCounts[index];
                    index++;
                }//end of if
                else {
                    index++;
                }//end of else
            }// end of while
            return busiestHour;
    }// end of busiestHour
    
    public int twobusiestHour()
    {
            int numberOfAccessesAtBusiest = 0;
            int busiestHour = 0;
            int index = 0;
            while(index < hourCounts.length - 1){
                if (numberOfAccessesAtBusiest < hourCounts[index] + hourCounts[index + 1]){
                    busiestHour = index;
                    numberOfAccessesAtBusiest = hourCounts[index] + hourCounts[index + 1];
                    index++;
                }//end of if
                else {
                    index++;
                }//end of else 
            }//end of while
            return busiestHour;
    }//end of twobusiesthour          
}// end of logAnalyzer