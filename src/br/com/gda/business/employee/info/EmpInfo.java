package br.com.gda.business.employee.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoRecord;

public final class EmpInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codPerson;
	public String codEntityCateg;
	public PersonInfo personData;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	
	
	
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

	
	
	public EmpInfo() {
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codPerson = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = RecordMode.RECORD_OK;
		personData = DefaultValue.object();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
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
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpInfo))
			return false;
		
		
		EmpInfo obj = (EmpInfo) o;		
		return (codOwner == obj.codOwner && codEmployee == obj.codEmployee);
	}
}
