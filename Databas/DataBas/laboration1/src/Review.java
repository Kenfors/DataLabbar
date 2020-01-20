package db_lab1.representation;

public class Review {
	private int reviewNo;
	private String message;
	private int score;
	private Book writtenFor;
	
	public Review(int no, String msg, int scoreIn, Book forBook) {
		setReviewNo(no);
		setMessage(msg);
		setScore(scoreIn);
		setWrittenFor(forBook);
		
		
	}
	public Review(String msg, int scoreIn, Book forBook) {
		setMessage(msg);
		setScore(scoreIn);
		setWrittenFor(forBook);
		
		
	}

	public int getReviewNo() {return reviewNo;}
	public void setReviewNo(int reviewNo) {this.reviewNo = reviewNo;}
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
	public int getScore() {return score;}
	public void setScore(int score) {this.score = score;}
	public Book getWrittenFor() {return writtenFor;}
	public void setWrittenFor(Book writtenFor) {this.writtenFor = writtenFor;}

	
	
}