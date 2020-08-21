package br.com.mind5.masterData.materialSubgroupSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public class MatubuparchInfo extends InfoRecord implements Cloneable {
	public int codSubgroup;
	public String txtSubgroup;
	public int codGroup;
	
	
	public MatubuparchInfo() {
		super();
		
		codGroup = DefaultValue.number();
		codSubgroup = DefaultValue.number();
	}
	
	
	
	public static MatubuparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatubuparchInfo.class);
	}
	
	
	
	public static List<MatubuparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatubuparchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + codSubgroup;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatubuparchInfo))
			return false;
		
		
		MatubuparchInfo obj = (MatubuparchInfo) o;		
		return (codSubgroup == obj.codSubgroup);
	}
}
