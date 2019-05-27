package br.com.gda.business.cart.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CartInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codCustomer;
	public long codUser;
	public String codLanguage;
	public LocalDateTime lastChanged;
	public String username;
	public List<CartemInfo> cartems;
	
	
	
	public CartInfo() {
		codOwner = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codLanguage = DefaultValue.language();
		cartems = DefaultValue.list();
	}
	
	
	
	public static CartInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CartInfo.class);
	}
	
	
	
	public static List<CartInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CartInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CartInfo deepCopy = (CartInfo) super.clone();
		
		if (lastChanged != null)
			deepCopy.lastChanged = lastChanged;
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		result = result * 31 + (int) (codUser 	  ^ (codUser 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CartInfo))
			return false;
		
		
		CartInfo obj = (CartInfo) o;		
		return (codOwner    == obj.codOwner    && 
				codCustomer == obj.codCustomer &&
				codUser     == obj.codUser			);
	}
}
