package br.com.mind5.masterData.genderSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class GendarchInfo extends InfoRecord implements Cloneable {
	public int codGender;
	public String txtGender;
	
	
	public GendarchInfo() {
		super();
		
		codGender = DefaultValue.number();
	}
	
	
	
	public static GendarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, GendarchInfo.class);
	}
	
	
	
	public static List<GendarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, GendarchInfo.class);
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
		
		
		if (!(o instanceof GendarchInfo))
			return false;
		
		
		GendarchInfo obj = (GendarchInfo) o;		
		return (codGender == obj.codGender);
	}
}
