package br.com.mind5.stats.userStoreAggr.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StusoraggInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codUser;
	public String codCurr;
	public String txtCurr;	
	public double totalPrice;
	public double totalPrice01m;
	public double totalPrice03m;
	public double totalPrice06m;
	public double totalPrice12m;
	public double totalPrice24m;	
	public int totalQuantity;
	public int totalQuantity01m;
	public int totalQuantity03m;
	public int totalQuantity06m;
	public int totalQuantity12m;
	public int totalQuantity24m;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public StusoraggInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();
		totalPrice = DefaultValue.number();
		totalPrice01m = DefaultValue.number();
		totalPrice03m = DefaultValue.number();
		totalPrice06m = DefaultValue.number();
		totalPrice12m = DefaultValue.number();
		totalPrice24m = DefaultValue.number();
		totalQuantity = DefaultValue.number();
		totalQuantity01m = DefaultValue.number();
		totalQuantity03m = DefaultValue.number();
		totalQuantity06m = DefaultValue.number();
		totalQuantity12m = DefaultValue.number();
		totalQuantity24m = DefaultValue.number();
	}
	
	
	
	public static StusoraggInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StusoraggInfo.class);
	}
	
	
	
	public static List<StusoraggInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StusoraggInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		result = result * 31 + (int) (codUser  ^ (codUser  >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StusoraggInfo))
			return false;
		
		
		StusoraggInfo obj = (StusoraggInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				codUser  == obj.codUser		);
	}
}
