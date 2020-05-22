package br.com.mind5.masterData.movimentType.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MamovypeInfo extends InfoRecord implements Cloneable {
	public char codMatmovType;
	public String txtMatmovType;
	
	
	public MamovypeInfo() {
		super();
		
		codMatmovType = DefaultValue.character();
	}
	
	
	
	public static MamovypeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MamovypeInfo.class);
	}
	
	
	
	public static List<MamovypeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MamovypeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) codMatmovType;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MamovypeInfo))
			return false;
		
		
		MamovypeInfo obj = (MamovypeInfo) o;		
		return (codMatmovType == obj.codMatmovType);
	}
}
