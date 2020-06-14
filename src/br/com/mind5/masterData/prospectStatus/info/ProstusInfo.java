package br.com.mind5.masterData.prospectStatus.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class ProstusInfo extends InfoRecord implements Cloneable {
	public String codProspectStatus;
	public String txtProspectStatus;
	
	
	public ProstusInfo() {
		super();
	}
	
	
	
	public static ProstusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, ProstusInfo.class);
	}
	
	
	
	public static List<ProstusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, ProstusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		if (codProspectStatus == null)
			return 0;
		
		return codProspectStatus.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof ProstusInfo))
			return false;
		
		
		ProstusInfo obj = (ProstusInfo) o;		
		return (isStringEqual(codProspectStatus, obj.codProspectStatus) );
	}
}
