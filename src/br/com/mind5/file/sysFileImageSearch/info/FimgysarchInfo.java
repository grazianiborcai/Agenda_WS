package br.com.mind5.file.sysFileImageSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FimgysarchInfo extends InfoRecord implements Cloneable {
	public long codFileImg;
	public int codGroup;
	public String recordMode;
	public String username;
	
	
	public FimgysarchInfo() {
		super();
		
		codFileImg = DefaultValue.number();	
		codGroup = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static FimgysarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FimgysarchInfo.class);
	}
	
	
	
	public static List<FimgysarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FimgysarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codGroup   ^ (codGroup   >>> 32));
		result = result * 31 + (int) (codFileImg ^ (codFileImg >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FimgysarchInfo))
			return false;
		
		
		FimgysarchInfo obj = (FimgysarchInfo) o;		
		return (codGroup    == obj.codGroup   && 
				codFileImg 	== obj.codFileImg		);
	}	
}
