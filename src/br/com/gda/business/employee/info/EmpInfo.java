package br.com.gda.business.employee.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class EmpInfo extends RecordInfo implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public List<Long> stores; //TODO: remover esse campo
	public String cpf;
	public String name;
	public int codGender;
	public String txtGender;
	public LocalDate birthDate;
	public String email;
	public String address1;
	public String address2;
	public long postalCode;
	public String city;
	public String codCountry;
	public String txtCountry;
	public String stateProvince;
	public String phone;
	public LocalTime beginTime;	 //TODO: remover esse campo
	public LocalTime endTime;	 //TODO: remover esse campo
	public long codPosition;	 //TODO: remover esse campo
	public String txtPosition;	 //TODO: remover esse campo
	public String codLanguage;
	public String recordMode;
	
	
	public EmpInfo() {
		this.codOwner = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.stores = new ArrayList<>();
		this.codGender = DefaultValue.number();
		this.postalCode = DefaultValue.number();
		this.codPosition = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;		
	}
	
	
	
	public static EmpInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpInfo.class);
	}
	
	
	
	public static List<EmpInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		EmpInfo deepCopy = (EmpInfo) super.clone();  		
		
		LocalTime cloneBeginTime = null;		
		if (beginTime != null) 
			cloneBeginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute(), beginTime.getSecond());
		
		LocalTime cloneEndTime = null;		
		if (endTime != null) 
			cloneEndTime = LocalTime.of(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
		
		LocalDate cloneBirthDate = null;		
		if (birthDate != null) 
			cloneBirthDate = LocalDate.of(birthDate.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth());
				
		
		deepCopy.beginTime = cloneBeginTime;
		deepCopy.endTime = cloneEndTime;
		deepCopy.birthDate = cloneBirthDate;
				
		return deepCopy;	
	}  
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * (int) (codEmployee ^ (codEmployee >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpInfo))
			return false;
		
		
		EmpInfo emp = (EmpInfo) o;		
		return (codOwner == emp.codOwner && codEmployee == emp.codEmployee);
	}
}
