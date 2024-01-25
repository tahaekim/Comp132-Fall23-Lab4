package research;
import java.util.ArrayList;
import resource.*;

public class ResearchService {

	protected String serviceName;
	protected ArrayList <Researcher> researchers;
	protected ArrayList <Resource> resource;
	
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
  	}
	
	public ArrayList<Researcher> getResearchers() {
		return researchers;
	}

	public void setResearchers(ArrayList<Researcher> researchers) {
		this.researchers = researchers;
  	}
	
	public ArrayList<Resource> getResource() {
		return resource;
	}

	public ResearchService(String serviceName) {
		this.serviceName = serviceName;
		resource = new ArrayList<Resource>();
	    researchers = new ArrayList<Researcher>();
  	}
	
	public void addResource(Resource m) {
		resource.add(m);
	}
	
	public boolean addResearcher(Researcher researcher) {
		for (Researcher item : researchers) {
			
            if (item.getResearcherName() == researcher.getResearcherName()) {
                System.out.println("Researcher with the same researcherName already exists.");
                return false;
            }
        }
		researchers.add(researcher);
        return true;
	}
	
	private Researcher getMostSimilarResearcher(Researcher researcher) {
		
		double max = 0;
		Researcher maxItem = null;
		for (Researcher item : researchers) {
			if(item.getResearcherName() != researcher.getResearcherName()) {
				double similarity = item.measureSimilarityWith(researcher);
				if(max < similarity) {
					maxItem = item;
					max = similarity;
				}
			}
		}
		return maxItem;
	}
	
	public Paper recommendPaperBySimilarResearcher(Researcher researcher) {
		Researcher mostSim = getMostSimilarResearcher(researcher);
		ArrayList<Paper> likedPapers = mostSim.getLikedPapers();
		
		int a = 1;
		Paper toReturn = null;
		for (Paper item : likedPapers) {
			boolean decide = researcher.getDownloaded().contains(item);
			if (decide == false && a == 1) {
				System.out.println("Most similar researcher is " + mostSim.getResearcherName() + " with a score of " + researcher.measureSimilarityWith(mostSim)); 
				toReturn = (Paper)item;
				a = 0;
            }
		}
		return toReturn;
	}
	
	public Resource recommendByField(Researcher researcher) {
		String favField = researcher.getFavoriteField();
		
		Resource toReturn = null;
		int a = 1;
		for (Resource item : resource) {
			if((item.getField() == favField) && (!researcher.getDownloaded().contains(item))  && (a == 1)){
				System.out.println("Your favorite field is: " + favField);
				toReturn = item;
				a = 0;
			}
		}
		return toReturn;
	}
	
}
