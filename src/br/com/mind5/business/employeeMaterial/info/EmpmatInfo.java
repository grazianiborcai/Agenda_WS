package br.com.mind5.business.employeeMaterial.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmpmatInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codMat;
	public MatInfo matData;
	public EmplisInfo emplisData;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public EmpmatInfo() {
		super(EmpmatInfo.class);
		
		codOwner = DefaultValue.number();	
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		codMat = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		lastChangedBy = DefaultValue.number();
		matData = DefaultValue.object();
		emplisData = DefaultValue.object();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static EmpmatInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpmatInfo.class);
	}
	
	
	
	public static List<EmpmatInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpmatInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		EmpmatInfo deepCopy = (EmpmatInfo) super.clone();
		
		deepCopy.matData = cloneMat(deepCopy.matData);
		deepCopy.emplisData = cloneEmplis(deepCopy.emplisData);
		
		return deepCopy;
	}
	
	
	
	private MatInfo cloneMat(MatInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (MatInfo) recordInfo.clone();
	}
	
	
	
	private EmplisInfo cloneEmplis(EmplisInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (EmplisInfo) recordInfo.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpmatInfo))
			return false;
		
		
		EmpmatInfo obj = (EmpmatInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codEmployee == obj.codEmployee 	&&
				codMat 		== obj.codMat);
	}
}
