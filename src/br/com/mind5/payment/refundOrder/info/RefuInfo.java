package br.com.mind5.payment.refundOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefuInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codOrder;
	public long codPayOrder;
	public List<OrdemarchInfo> ordemarches;
	public String username;	
	
	
	public RefuInfo() {
		super(RefuInfo.class);
		
		codOwner = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codOrder = DefaultValue.number();
		ordemarches = DefaultValue.list();
	}
	
	
	
	public static RefuInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefuInfo.class);
	}
	
	
	
	public static List<RefuInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefuInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		RefuInfo deepCopy = (RefuInfo) super.clone();
		
		deepCopy.ordemarches = cloneOrdemarches(deepCopy.ordemarches);
		
		return deepCopy;
	}
	
	
	
	private List<OrdemarchInfo> cloneOrdemarches(List<OrdemarchInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		if (recordInfos.isEmpty())
			return recordInfos;
		
		
		List<OrdemarchInfo> results = new ArrayList<>();
		
		for (OrdemarchInfo eachRecord : recordInfos) {
			OrdemarchInfo eachResult = (OrdemarchInfo) eachRecord.clone();
			results.add(eachResult);
		}
		
		return recordInfos;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codPayOrder ^ (codPayOrder >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefuInfo))
			return false;
		
		
		RefuInfo obj = (RefuInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codPayOrder == obj.codPayOrder		);
	}
}
