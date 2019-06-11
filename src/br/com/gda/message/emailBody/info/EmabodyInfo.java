package br.com.gda.message.emailBody.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class EmabodyInfo extends InfoRecord implements Cloneable {
	public String codBody;
	public String txtbody;
	public String subject;
	public String param01;
	public String param02;
	public String param03;
	public String param04;
	public String param05;
	public String username;
	public String codLanguage;
	
	
	public EmabodyInfo() {
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static EmabodyInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmabodyInfo.class);
	}
	
	
	
	public static List<EmabodyInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmabodyInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;	
		
		if (codBody != null)
			result = result * 31 + codBody.hashCode();
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		if (param01 != null)
			result = result * 31 + param01.hashCode();
		
		if (param02 != null)
			result = result * 31 + param02.hashCode();
		
		if (param03 != null)
			result = result * 31 + param03.hashCode();
		
		if (param04 != null)
			result = result * 31 + param04.hashCode();
		
		if (param05 != null)
			result = result * 31 + param05.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmabodyInfo))
			return false;
		
		
		EmabodyInfo obj = (EmabodyInfo) o;		
		return (super.isStringEqual(codBody, obj.codBody)			&&				
				super.isStringEqual(codLanguage, obj.codLanguage)	&&
				super.isStringEqual(param01, obj.param01)			&&
				super.isStringEqual(param02, obj.param02)			&&
				super.isStringEqual(param03, obj.param03)			&&
				super.isStringEqual(param04, obj.param04)			&&
				super.isStringEqual(param05, obj.param05)				);
	}	
}
