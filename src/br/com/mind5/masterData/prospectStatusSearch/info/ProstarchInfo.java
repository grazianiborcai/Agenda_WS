package br.com.mind5.masterData.prospectStatusSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class ProstarchInfo extends InfoRecord implements Cloneable {
	public String codProspectStatus;
	public String txtProspectStatus;
	
	
	public ProstarchInfo() {
		super();
	}
	
	
	
	public static ProstarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, ProstarchInfo.class);
	}
	
	
	
	public static List<ProstarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, ProstarchInfo.class);
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
		
		
		if (!(o instanceof ProstarchInfo))
			return false;
		
		
		ProstarchInfo obj = (ProstarchInfo) o;		
		return (isStringEqual(codProspectStatus, obj.codProspectStatus));
	}
}
