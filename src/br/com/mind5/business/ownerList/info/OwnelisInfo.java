package br.com.mind5.business.ownerList.info;

import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OwnelisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public int codBusiness;
	public String txtBusiness; 
	public long codCompany;
	public String username;
	public String recordMode;
	public ComplisInfo complisData;
	
	
	
	public OwnelisInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codBusiness = DefaultValue.number();
		codCompany = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		complisData = DefaultValue.object();
	}
	
	
	
	public static OwnelisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwnelisInfo.class);
	}
	
	
	
	public static List<OwnelisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwnelisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OwnelisInfo deepCopy = (OwnelisInfo) super.clone();
		
		deepCopy.complisData = CloneUtil.cloneRecord(deepCopy.complisData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OwnelisInfo))
			return false;
		
		
		OwnelisInfo obj = (OwnelisInfo) o;		
		return (codOwner == obj.codOwner);
	}	
}
