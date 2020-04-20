package br.com.mind5.masterData.materialUnit.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class MatunitInfo extends InfoRecord implements Cloneable {
	public String codUnit;
	public String txtUnit;
	
	
	public MatunitInfo() {
		super();
	}
	
	
	
	public static MatunitInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatunitInfo.class);
	}
	
	
	
	public static List<MatunitInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatunitInfo.class);
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
		
		
		if (!(o instanceof MatunitInfo))
			return false;
		
		
		MatunitInfo obj = (MatunitInfo) o;
		return isStringEqual(codUnit, obj.codUnit);
	}
}
