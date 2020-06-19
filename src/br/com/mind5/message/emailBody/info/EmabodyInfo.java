package br.com.mind5.message.emailBody.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class EmabodyInfo extends InfoRecord implements Cloneable {
	public String codBody;
	public String txtbody;
	public String subject;
	public String param01;
	public String param02;
	public String param03;
	public String param04;
	public String param05;
	public String param06;
	public String param07;
	public String param08;
	public String param09;
	public String param10;
	public String username;
	
	
	public EmabodyInfo() {
		super();
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
		
		if (param06 != null)
			result = result * 31 + param06.hashCode();
		
		if (param07 != null)
			result = result * 31 + param07.hashCode();
		
		if (param08 != null)
			result = result * 31 + param08.hashCode();
		
		if (param09 != null)
			result = result * 31 + param09.hashCode();
		
		if (param10 != null)
			result = result * 31 + param10.hashCode();
		
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
				super.isStringEqual(param05, obj.param05)			&&
				super.isStringEqual(param06, obj.param06)			&&
				super.isStringEqual(param07, obj.param07)			&&
				super.isStringEqual(param08, obj.param04)			&&
				super.isStringEqual(param09, obj.param09)			&&
				super.isStringEqual(param10, obj.param10)				);
	}	
}
