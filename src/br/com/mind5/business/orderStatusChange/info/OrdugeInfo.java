package br.com.mind5.business.orderStatusChange.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OrdugeInfo extends InfoRecord implements Cloneable {
	public String codOrderStatusOld;
	public String codOrderStatusNew;
	public long codPayOrder;
	public String username;
	
	
	public OrdugeInfo() {
		super();
		
		codPayOrder = DefaultValue.number();
	}
	
	
	
	public static OrdugeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdugeInfo.class);
	}
	
	
	
	public static List<OrdugeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdugeInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codOrderStatusOld == null)
			return result;
		
		return codOrderStatusOld.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdugeInfo))
			return false;
		
		
		OrdugeInfo obj = (OrdugeInfo) o;		
		return (super.isStringEqual(codOrderStatusOld, obj.codOrderStatusOld));
	}
}
