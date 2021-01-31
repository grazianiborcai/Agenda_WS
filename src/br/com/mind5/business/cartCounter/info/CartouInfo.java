package br.com.mind5.business.cartCounter.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CartouInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codUser;
	public int itemCounter;
	public List<CartemInfo> cartems;
	public String username;
	
	
	public CartouInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codUser = DefaultValue.number();
		itemCounter = DefaultValue.number();
		cartems = DefaultValue.list();
	}
	
	
	
	public static CartouInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CartouInfo.class);
	}
	
	
	
	public static List<CartouInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CartouInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CartouInfo deepCopy = (CartouInfo) super.clone();
		
		deepCopy.cartems = CloneUtil.cloneRecords(cartems, this.getClass());		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codUser 	  ^ (codUser 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CartouInfo))
			return false;
		
		
		CartouInfo obj = (CartouInfo) o;		
		return (codOwner    == obj.codOwner    && 
				codUser     == obj.codUser			);
	}
}
