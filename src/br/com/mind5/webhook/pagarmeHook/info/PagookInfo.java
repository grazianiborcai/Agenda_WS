package br.com.mind5.webhook.pagarmeHook.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PagookInfo extends InfoRecord implements Cloneable {
	public String id;
	public String event;
	public Data data;
	public long codOwner;
	public long codPayOrder;
	public long codPayOrderItem;
	public String username;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	
	
	class Data {
		public String id;
		public String code;
		public String status;
	}
	
	
	public PagookInfo() {
		super();
		
		data        	= DefaultValue.object();
		codOwner        = DefaultValue.number();
		createdOn		= DefaultValue.object();		
		lastChanged		= DefaultValue.object();
		codPayOrder     = DefaultValue.number();
		codPayOrderItem = DefaultValue.number();
	}
	
	
	
	public static PagookInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PagookInfo.class);
	}
	
	
	
	public static List<PagookInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PagookInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (id != null)		
			result = result * 31 + (int) (id.hashCode() ^ (id.hashCode() >>> 32));
		
		return result;
	}	
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PagookInfo))
			return false;
		
		
		PagookInfo obj = (PagookInfo) o;		
		return (super.isStringEqual(id, obj.id));
	}
}
