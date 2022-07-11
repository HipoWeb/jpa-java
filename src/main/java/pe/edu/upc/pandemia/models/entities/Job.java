package pe.edu.upc.pandemia.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Jobs")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id", length = 10)
	private String id;
	@Column(name = "job_title", length = 35, nullable = false)
	private String title;
	@Column(name = "min_salary", columnDefinition = "NUMERIC(6)")
	private String minSalary;
	@Column(name = "max_salary", columnDefinition = "NUMERIC(6)")
	private String maxSalary;
	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)	
	private List<Employee> employees;
	
	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
	private List<JobHistory> jobHistories;
	
	//constructor , getter and setter
	
	public Job(){
		employees = new ArrayList<Employee>();
		jobHistories = new ArrayList<JobHistory>();
		
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<JobHistory> getJobHistories() {
		return jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}
	
	

}
