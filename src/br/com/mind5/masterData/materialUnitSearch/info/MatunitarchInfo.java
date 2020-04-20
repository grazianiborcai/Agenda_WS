package br.com.mind5.masterData.materialUnitSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class MatunitarchInfo extends InfoRecord implements Cloneable {
	public String codUnit;
	public String txtUnit;
	
	
	public MatunitarchInfo() {
		super();
	}
	
	
	
	public static MatunitarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatunitarchInfo.class);
	}
	
	
	
	public static List<MatunitarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatunitarchInfo.class);
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
		
		
		if (!(o instanceof MatunitarchInfo))
			return false;
		
		
		MatunitarchInfo obj = (MatunitarchInfo) o;
		return isStringEqual(codUnit, obj.codUnit);
	}
}
