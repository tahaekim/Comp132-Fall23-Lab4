package research;

import java.util.ArrayList;

import resource.*;

public class Researcher {
	
	protected String researcherName;
	protected ArrayList <Resource> downloaded;
	protected ArrayList <Resource> liked;
	
	public String getResearcherName() {
      return researcherName;
	}

	public void setResearcherName(String researcherName) {
      this.researcherName = researcherName;
  	}
	
	public ArrayList<Resource> getDownloaded() {
      return downloaded;
	}

	public void setDownloaded(ArrayList<Resource> downloaded) {
      this.downloaded = downloaded;
  	}
	
	public ArrayList<Resource> getLiked() {
      return liked;
	}

	public void setLiked(ArrayList<Resource> liked) {
      this.liked = liked;
  	}
	
	public Researcher(String researcherName) {
		this.researcherName = researcherName;
		this.downloaded = new ArrayList<>();
		this.liked = new ArrayList<>();
	}
	
	public void download(Resource m, boolean like) {
		downloaded.add(m);
		int numDwnld = m.getNumDwnld();
		m.setNumDwnld(numDwnld + 1);
		
		if(like == true) {
			liked.add(m);
		}
	}
	
	public String getFavoriteField() {
		ArrayList<String> fields = new ArrayList<String>();
		ArrayList<Integer> numLikes = new ArrayList<Integer>();
		
		for (Resource item : liked) {
			String field = item.getField();
			
			if(fields.contains(field)) {
				int ind = fields.indexOf(field);
				int num = numLikes.get(ind);
				num++;
				numLikes.set(ind, num);
			}
			
			else {
				fields.add(field);
				numLikes.add(1);
			}
        }
		
		int max = 0;
		for(int item2 : numLikes) {

			if (item2 > max) {
				max = item2;
			}
		}
		
		int maxInd = numLikes.indexOf(max);
		return fields.get(maxInd);
	}
	
	public ArrayList<Paper> getLikedPapers(){
		ArrayList<Paper> likedPapers = new ArrayList<Paper>();
		
		for (Resource item : liked) {
			
			if(item instanceof Paper) {
				likedPapers.add((Paper)item);
			}
        }
		return likedPapers;
	}
	
	public ArrayList<ProceedingBook> getLikedProceedingBook(){
		ArrayList<ProceedingBook> likedPapers = new ArrayList<ProceedingBook>();
		
		for (Resource item : liked) {
			if(item instanceof ProceedingBook) {
				likedPapers.add((ProceedingBook)item);
			}
        }
		return likedPapers;
		
	}
	
	public double measureSimilarityWith(Researcher r) {
		ArrayList<Resource> liked1 = r.getLiked();
		double numSim = 0;
		
		for (int i = 0; i < liked.size(); i++) {
			for(int a = 0; a < liked1.size(); a++) {
				if(liked.get(i) == liked1.get(a)) {
					numSim++;
				}
			}
		}
		return numSim;
	}

}
