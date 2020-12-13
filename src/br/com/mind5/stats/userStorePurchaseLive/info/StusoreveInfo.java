package br.com.mind5.stats.userStorePurchaseLive.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StusoreveInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codUser;
	public String codCurr1;
	public String txtCurr1;	
	public double totalPrice1;
	public int totalQuantity;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public StusoreveInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();
		totalPrice1 = DefaultValue.number();
		totalQuantity = DefaultValue.number();
	}
	
	
	
	public static StusoreveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StusoreveInfo.class);
	}
	
	
	
	public static List<StusoreveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StusoreveInfo.class);
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
		
		
		if (!(o instanceof StusoreveInfo))
			return false;
		
		
		StusoreveInfo obj = (StusoreveInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				codUser  == obj.codUser		);
	}
}
