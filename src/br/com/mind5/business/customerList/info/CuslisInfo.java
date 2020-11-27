package br.com.mind5.business.customerList.info;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;

public final class CuslisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codStore;
	public long codSnapshot;
	public long codPerson;
	public long codUser;
	public String recordMode;
	public PersolisInfo persolisData;
	public FimistInfo fimistData;
	public String username;
	
	
	public CuslisInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		persolisData = DefaultValue.object();
		fimistData = DefaultValue.object();
	}
	
	
	
	public static CuslisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CuslisInfo.class);
	}
	
	
	
	public static List<CuslisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CuslisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CuslisInfo deepCopy = (CuslisInfo) super.clone();		
		
		deepCopy.persolisData = CloneUtil.cloneRecord(deepCopy.persolisData, this.getClass());		
		deepCopy.fimistData = CloneUtil.cloneRecord(deepCopy.fimistData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CuslisInfo))
			return false;
		
		
		CuslisInfo obj = (CuslisInfo) o;		
		return (codOwner    == obj.codOwner && 
				codCustomer == obj.codCustomer);
	}
}
