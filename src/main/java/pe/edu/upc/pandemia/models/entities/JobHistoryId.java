package pe.edu.upc.pandemia.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class JobHistoryId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer employee;
	private Date startDate;
	
	@Override
	public int hashCode() {
		return Objects.hash(employee, startDate);
		
	}
	//Getter y Setter
	
	public Integer getEmployee() {
		return employee;
	}
	public void setEmployee(Integer employee) {
		this.employee = employee;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	//constructor
	public JobHistoryId(Integer employee, Date startDate) {
		super();
		this.employee = employee;
		this.startDate = startDate;
	}
	
	
	public JobHistoryId() {
		super();
	}

	//todo esto es para indices compuestos
	//if(a==b) comprar objetos 
	@Override
	public boolean equals(Object obj) {
		//si es el mismo
		if(this==obj)
			return true;
		//si el obj es null
		if(obj == null || getClass() != obj.getClass() )
			return false;
		//verificar que los atributos sean iguales
		//cast
		JobHistoryId jobHistoryId = (JobHistoryId)obj;
		
		if(this.employee != jobHistoryId.employee)
			return false;
		if(this.startDate != jobHistoryId.startDate)
			return false;
		return true;
	}
	
}
