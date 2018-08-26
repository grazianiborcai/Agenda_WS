package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class MatUnitInfo extends InfoRecord implements Cloneable {
	public String codUnit;
	public String txtUnit;
	public String codLanguage;
	
	
	public MatUnitInfo() {
		this.codLanguage = DefaultValue.language();
	}
	
	
	
	public static MatUnitInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatUnitInfo.class);
	}
	
	
	
	public static List<MatUnitInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatUnitInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codUnit != null) {
			char[] chars = codUnit.toCharArray();
			
			for (char eachChar : chars) {
				result = result * 31 + (int) eachChar;
			}
		}		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatUnitInfo))
			return false;
		
		
		MatUnitInfo obj = (MatUnitInfo) o;
		return isStringEqual(codUnit, obj.codUnit);
	}
}
