package br.com.gda.message.sysMessage.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class SymsgInfo extends InfoRecord implements Cloneable {
	public String codLanguageBase;
	public int codMsg;
	public String txtMsg;
	
	
	public SymsgInfo() {
		super(SymsgInfo.class);
		
		codMsg = DefaultValue.number();
		codLanguageBase = DefaultValue.language();
	}
	
	
	
	public static SymsgInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SymsgInfo.class);
	}
	
	
	
	public static List<SymsgInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SymsgInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		result = result * 31 + (int) (codMsg ^ (codMsg >>> 32));		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SymsgInfo))
			return false;
		
		
		SymsgInfo obj = (SymsgInfo) o;		
		return (codMsg == obj.codMsg);
	}	
}
