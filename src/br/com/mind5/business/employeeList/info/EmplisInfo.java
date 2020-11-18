package br.com.mind5.business.employeeList.info;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;

public final class EmplisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codStore;
	public long codSnapshot;
	public long codPerson;
	public PersolisInfo persolisData;
	public FimistInfo fimistData;
	public String recordMode;
	public String username;
	
	
	public EmplisInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		persolisData = DefaultValue.object();
		fimistData = DefaultValue.object();
	}
	
	
	
	public static EmplisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmplisInfo.class);
	}
	
	
	
	public static List<EmplisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmplisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		EmplisInfo deepCopy = (EmplisInfo) super.clone(); 

		deepCopy.persolisData = CloneUtil.cloneRecord(deepCopy.persolisData, this.getClass());
		deepCopy.fimistData = CloneUtil.cloneRecord(deepCopy.fimistData, this.getClass());
		
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
		
		
		if (!(o instanceof EmplisInfo))
			return false;
		
		
		EmplisInfo obj = (EmplisInfo) o;		
		return (codOwner    == obj.codOwner    && 
				codEmployee == obj.codEmployee		);
	}
}
