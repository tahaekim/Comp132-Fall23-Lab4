package research;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import resource.Resource;

public class PremiumResearcher extends Researcher {
	private LocalDate startDate;
	private double fee;
	private boolean monthly;
	
	public PremiumResearcher(String username, LocalDate startDate,double fee, boolean monthly){
		super(username);
		this.startDate = startDate;
		this.fee = fee;
		this.monthly = monthly;
	}
	
	public double calculateTotalFee () {
		LocalDate lt = LocalDate.now();
		double totalFee = 0;
		if (monthly == true) {
			long noOfMonths = ChronoUnit.MONTHS.between(startDate,lt);
			totalFee = fee * noOfMonths;
		}
		else {
			long noOfYears = ChronoUnit.YEARS.between(startDate,lt);
			totalFee = fee * noOfYears;
		}
		return totalFee;
	}
	
	
	public double measureSimilarityWith(Researcher u) {
		ArrayList<Resource> liked1 = u.getLiked();
		ArrayList<Resource> downloaded1 = u.getDownloaded();
		int a = 0;
		int b = 0;
		int c = 0;
		
		for (Resource item : downloaded) {
			for (Resource item1 : downloaded1) {
				if (( item == item1)  && (liked1.contains(item) && liked.contains(item))){
					a++;
				}
				else if(( item == item1)  && (!liked1.contains(item) && liked.contains(item))){
					b++;
				}
				else if (( item == item1)  && (liked1.contains(item) && !liked.contains(item))) {
					c++;
				}
			}
		}
		double jaccardSim = (double) a/(a + b + c);
		return jaccardSim;
	}
}
