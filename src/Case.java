
public class Case {

	/* Attributes */
	private State state;
	private Content content;

	/* Enum */
	public enum State {
		hidden,
		open,
		flagged,
		asked
	}
	
	public enum Content {
		empty,
		one,
		two,
		three,
		four,
		five,
		six,
		seven,
		eight,
		bomb
	}
	
	/* Constructors */
	public Case() {
		this(Content.empty);
	}
	public Case(Content content) {
		this(content, State.hidden);
	}
	public Case(Content content, State state) {
		this.content = content;
		this.state = state;
	}
	
	/* Getters */
	public State getState() {
		return this.state;
	}
	public Content getContent() {
		return this.content;
	}
	
	/* Setters */
	public void setState(State state) {
		this.state = state;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	
}
