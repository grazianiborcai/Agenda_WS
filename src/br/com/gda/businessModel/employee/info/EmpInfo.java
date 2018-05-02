package br.com.gda.businessModel.employee.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class EmpInfo implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public List<Long> stores;
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
	public LocalTime beginTime;
	public LocalTime endTime;
	public long codPosition;	
	public String txtPosition;
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
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
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
}
