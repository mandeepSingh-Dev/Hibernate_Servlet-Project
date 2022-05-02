package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "files")
@Table(name = "files")
public class Files {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="fileName")

	private String fileName;
	
		public Files() {
		super();
	}
		
	public Files(int id, String fileName, String label, String caption, String username, int rollnumber,
			String course) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.label = label;
		this.caption = caption;
		this.username = username;
		this.rollnumber = rollnumber;
		this.course = course;
	}



	public Files(String fileName, String label, String caption, String username, int rollnumber, String course) {
		super();
		this.fileName = fileName;
		this.label = label;
		this.caption = caption;
		this.username = username;
		this.rollnumber = rollnumber;
		this.course = course;
	}
	//construcotr for only update purpose this data will send to filemodel to update 
	public Files(String label, String caption, String username, int rollno)
	{
		this.label = label;
		this.caption = caption;
		this.username = username;
		rollnumber= rollno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Column(name="label")
	private String label;
	
	@Column(name="caption")
	private String caption;
	
	@Column(name="username")
    public 	String username;
	
	@Column(name="rollnumber")
	public int rollnumber;
	
	@Column(name="course")
	public String course;
}
