package message.domain;

public class AdmissionInformation {
	
	private int id;
	
	//专业
	private String major;
	
	//文理类别区分
	private String type;
	
	//计划招生数
	private int plan;
	
	//录取最低分
	private double score_min;
	
	//录取最高分
	private double score_max;
	
	//录取平均分
	private double avg;
	
	//控制线
	private double control;
	
	//地区
	private String location;
	
	//年份
	private int year;

	public AdmissionInformation() {
		super();
	}

	public AdmissionInformation(int id, String major, String type, int plan, double score_min, double score_max,
			double avg, double control, String location, int year) {
		super();
		this.id = id;
		this.major = major;
		this.type = type;
		this.plan = plan;
		this.score_min = score_min;
		this.score_max = score_max;
		this.avg = avg;
		this.control = control;
		this.location = location;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPlan() {
		return plan;
	}

	public void setPlan(int plan) {
		this.plan = plan;
	}

	public double getScore_min() {
		return score_min;
	}

	public void setScore_min(double score_min) {
		this.score_min = score_min;
	}

	public double getScore_max() {
		return score_max;
	}

	public void setScore_max(double score_max) {
		this.score_max = score_max;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getControl() {
		return control;
	}

	public void setControl(double control) {
		this.control = control;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "AdmissionInformation [id=" + id + ", major=" + major + ", type=" + type + ", plan=" + plan
				+ ", score_min=" + score_min + ", score_max=" + score_max + ", avg=" + avg + ", control=" + control
				+ ", location=" + location + ", year=" + year + "]";
	}
	
	
	
	
}
