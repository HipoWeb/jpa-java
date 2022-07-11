package pe.edu.upc.pandemia.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Departments")
@SequenceGenerator(name = "GetDepartment", initialValue = 1)
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GetDepartment")
	@Column(name = "department_id", columnDefinition = "NUMERIC(4)") //ES PARA POSTGRES
	private Integer id;
	@Column(name = "department_name", length = 30)
	private String name;
	
	
	@OneToOne(mappedBy = "departmentManager", fetch = FetchType.EAGER)
	private Employee manager;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="location_id", nullable = false)
	private Location location;
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	//desbloquear cuando se crea el primary key compuesto
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<JobHistory> jobHistories;
	
	//constructor get and setter
	
	public Department(){
		employees = new ArrayList<Employee>();
		jobHistories = new ArrayList<JobHistory>();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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
