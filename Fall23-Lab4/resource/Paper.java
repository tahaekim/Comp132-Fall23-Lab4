package resource;

public class Paper extends Resource{
	protected String firstAuthor;
	
	public String getFirstAuthor() {
      return firstAuthor;
	}

	public void setFirstAuthor(String firstAuthor) {
      this.firstAuthor = firstAuthor;
  	}
	
	public Paper(String title, String field, String firstAuthor) {
		super(title, field);
	    this.firstAuthor = firstAuthor;
	}
}
