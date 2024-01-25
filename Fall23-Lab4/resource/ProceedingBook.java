package resource;

public class ProceedingBook extends Resource{
	protected int numPapers;
	protected int chapters;
	
	public int getNumPapers() {
		return numPapers;
	}

	public void setNumPapers(int numPapers) {
	    this.numPapers = numPapers;
	}
	  
	public int getChapters() {
		return chapters;
	}
	
	public void setChapters(int chapters) {
		this.chapters = chapters;
	}
	
	public ProceedingBook(String title, String field, int numPapers, int chapters) {
		super(title, field);
		numPapers = 0;
		chapters = 0;
	}
}
