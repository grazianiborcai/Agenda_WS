package br.com.gda.payment.setupPartner.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class SetuparInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String txtPayPartner;
	public String token;
	public String key;
	public String description;
	
	
	public SetuparInfo() {
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static SetuparInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SetuparInfo.class);
	}
	
	
	
	public static List<SetuparInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SetuparInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		result = result * 31 + codPayPartner;		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SetuparInfo))
			return false;
		
		
		SetuparInfo obj = (SetuparInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
