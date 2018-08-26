package br.com.gda.business.amount.info;

import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class AmountInfo extends InfoRecord implements Cloneable {
	public double amount;
	public int decimalPlace;
	public String codCurr;
	
	
	
	public AmountInfo() {
		amount = DefaultValue.number();
		decimalPlace = DefaultValue.decimalPlace();
		codCurr = DefaultValue.codCurrency();
	}
	
	
	
	public static AmountInfo copyFrom(Object sourceObj) {
		if (isCart(sourceObj))
			return copyFromCart(sourceObj);
		
		return copyFrom(sourceObj, AmountInfo.class);
	}
	
	
	
	public static List<AmountInfo> copyFrom(List<?> sourceObjs) {
		if (isCart(sourceObjs))
			return copyFromCart(sourceObjs);
		
		return copyFrom(sourceObjs, AmountInfo.class);
	}
	
	
	
	private static boolean isCart(List<?> sourceObjs) {
		if (sourceObjs == null || sourceObjs.isEmpty())
			return false;
		
		return isCart(sourceObjs.get(0));
	}
	
	
	
	private static boolean isCart(Object sourceObj) {
		if (sourceObj == null)
			return false;
		
		if (sourceObj instanceof CartInfo)
			return true;
		
		return false;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static List<AmountInfo> copyFromCart(List<?> sourceObjs) {
		return new AmountCopyCart().makeCopy( (List<CartInfo>)sourceObjs);
	}
	
	
	
	private static AmountInfo copyFromCart(Object sourceObj) {
		return new AmountCopyCart().makeCopy( (CartInfo)sourceObj);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return (AmountInfo) super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		result = result * 31 + (int) (amount * decimalPlace);
		result = result * 31 + codCurr.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AmountInfo))
			return false;
		
		
		AmountInfo obj = (AmountInfo) o;		
		return (amount       == obj.amount       && 
				decimalPlace == obj.decimalPlace &&
				codCurr.equals(obj.codCurr));
	}
}
