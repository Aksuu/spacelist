package hh.swd20.spacelist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class APOD {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String explanation, title, media_type;

	public APOD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public APOD(String explanation, String title, String media_type) {
		super();
		this.explanation = explanation;
		this.title = title;
		this.media_type = media_type;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	@Override
	public String toString() {
		return "APOD [explanation=" + explanation + ", title=" + title + ", media_type=" + media_type + "]";
	}
}
