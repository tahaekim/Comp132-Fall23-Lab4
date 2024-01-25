package resource;

public class Resource {
  protected String title;
  protected String field;
  protected int numDwnld;
  protected int likes;
  
  public String getTitle() {
      return title;
  }

  public void setTitle(String title) {
      this.title = title;
  }
  
  public String getField() {
      return field;
  }

  public void setField(String field) {
      this.field = field;
  }
  
  public int getNumDwnld() {
      return numDwnld;
  }

  public void setNumDwnld(int numDwnld) {
      this.numDwnld = numDwnld;
  }
  
  public int getLikes() {
      return likes;
  }

  public void setLikes(int likes) {
      this.likes = likes;
  }
  
  public Resource(String title, String field){
	  this.title = title;
	  this.field = field;
	  numDwnld = 0;
	  likes = 0;
  }
  
  public void addNumDwnld(boolean like) {
	  numDwnld++;
	  
	  if (like == true) {
		  likes++;
	  }
  }
  
  public double getRating() {
	  double result = 0;
	  if(numDwnld != 0) {
		  result = (double) likes / numDwnld;
		  
	  }else {
		  System.out.println("The number of download is 0");
	  }
	  return result;
  }
}
