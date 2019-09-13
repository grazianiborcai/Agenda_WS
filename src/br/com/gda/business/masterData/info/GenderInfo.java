package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class GenderInfo extends InfoRecord implements Cloneable {
	public int codGender;
	public String txtGender;
	
	
	public GenderInfo() {
		super(GenderInfo.class);
		
		codGender = DefaultValue.number();
	}
	
	
	
	public static GenderInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, GenderInfo.class);
	}
	
	
	
	public static List<GenderInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, GenderInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + codGender;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof GenderInfo))
			return false;
		
		
		GenderInfo obj = (GenderInfo) o;		
		return (codGender == obj.codGender);
	}
}
