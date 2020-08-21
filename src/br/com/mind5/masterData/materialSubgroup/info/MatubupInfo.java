package br.com.mind5.masterData.materialSubgroup.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public class MatubupInfo extends InfoRecord implements Cloneable {
	public int codSubgroup;
	public String txtSubgroup;
	public int codGroup;
	public String txtGroup; 
	
	
	public MatubupInfo() {
		super();
		
		codGroup = DefaultValue.number();
		codSubgroup = DefaultValue.number();
	}
	
	
	
	public static MatubupInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatubupInfo.class);
	}
	
	
	
	public static List<MatubupInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatubupInfo.class);
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
		
		
		if (!(o instanceof MatubupInfo))
			return false;
		
		
		MatubupInfo obj = (MatubupInfo) o;		
		return (codSubgroup == obj.codSubgroup);
	}
}
