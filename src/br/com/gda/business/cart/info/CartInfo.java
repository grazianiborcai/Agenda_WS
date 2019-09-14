package br.com.gda.business.cart.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CartInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codCustomer;
	public long codUser;
	public long codOrder;
	public double itemTotal;
	public double feeService;
	public double grandTotal;	
	public String codCurr;
	public String txtCurr;
	public LocalDateTime lastChanged;
	public String username;
	public List<CartemInfo> cartems;
	public String codLanguage;
	
	
	public CartInfo() {
		super(CartInfo.class);
		
		codOwner = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codOrder = DefaultValue.number();
		itemTotal = DefaultValue.number();
		feeService = 0;
		grandTotal = DefaultValue.number();
		cartems = DefaultValue.list();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static CartInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CartInfo.class);
	}
	
	
	
	public static List<CartInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CartInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CartInfo deepCopy = (CartInfo) super.clone();
		
		deepCopy.lastChanged = lastChanged;
		deepCopy.cartems = cloneCartems(cartems);
		
		return deepCopy;
	}
	
	
	
	private List<CartemInfo> cloneCartems(List<CartemInfo> recordInfos) throws CloneNotSupportedException {
		List<CartemInfo> results = new ArrayList<>();
		
		if (recordInfos == null)
			return null;
		
		for (CartemInfo eachRecord : recordInfos) {
			CartemInfo clonedRecord = (CartemInfo) eachRecord.clone();
			results.add(clonedRecord);
		}
		
		
		return results;
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
