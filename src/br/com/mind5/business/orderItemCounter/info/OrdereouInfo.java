package br.com.mind5.business.orderItemCounter.info;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OrdereouInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codOrder;
	public int itemCounter;
	public List<OrdemistInfo> ordemists;
	public String username;
	
	
	public OrdereouInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();
		itemCounter = DefaultValue.number();
		ordemists = DefaultValue.list();
	}
	
	
	
	public static OrdereouInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdereouInfo.class);
	}
	
	
	
	public static List<OrdereouInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdereouInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrdereouInfo deepCopy = (OrdereouInfo) super.clone();
		
		deepCopy.ordemists = CloneUtil.cloneRecords(ordemists, this.getClass());		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codOrder ^ (codOrder >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdereouInfo))
			return false;
		
		
		OrdereouInfo obj = (OrdereouInfo) o;		
		return (codOwner == obj.codOwner && 
				codOrder == obj.codOrder	);
	}
}
