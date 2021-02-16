package br.com.mind5.business.employeeRestricted.info;

import java.util.List;

import br.com.mind5.business.personRestricted.info.PersoresInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;

public final class EmplresInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public long codStore;
	public long codSnapshot;
	public long codPerson;
	public PersoresInfo persoresData;
	public FimistInfo fimistData;
	public String recordMode;
	public String username;
	
	
	public EmplresInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		persoresData = DefaultValue.object();
		fimistData = DefaultValue.object();
	}
	
	
	
	public static EmplresInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmplresInfo.class);
	}
	
	
	
	public static List<EmplresInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmplresInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {  
		EmplresInfo deepCopy = (EmplresInfo) super.clone(); 

		deepCopy.persoresData = CloneUtil.cloneRecord(deepCopy.persoresData, this.getClass());
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
		
		
		if (!(o instanceof EmplresInfo))
			return false;
		
		
		EmplresInfo obj = (EmplresInfo) o;		
		return (codOwner    == obj.codOwner    && 
				codEmployee == obj.codEmployee		);
	}
}
