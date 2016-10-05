package allAussieSports;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class salesReport
{
   private static final String repConst="rep";
   private static int totalReps=0;
   private HashMap<item,Integer> soldItems=new HashMap<item,Integer>();
   private String repCode,repSport;
   private LocalDate reportStart,reportFinish,reportGenerated;
   
   salesReport(LocalDate startDate,LocalDate endDate,String sport){
      repSport=sport;
      reportStart=startDate;
      reportFinish=endDate;
      reportGenerated=LocalDate.now();
      soldItems=purchase.getSales(startDate,endDate,sport);
      
   }
   
   /*Accessors*/
   
   /*Mutators*/
   
}
