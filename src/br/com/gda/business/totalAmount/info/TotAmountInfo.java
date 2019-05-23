package br.com.gda.business.totalAmount.info;

import java.util.List;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class TotAmountInfo extends InfoRecord implements Cloneable {
	public double amount;
	public int decimalPlace;
	public String codCurr;
	
	
	
	public TotAmountInfo() {
		amount = DefaultValue.number();
		decimalPlace = DefaultValue.decimalPlace();
		codCurr = DefaultValue.codCurrency();
	}
	
	
	
	public static TotAmountInfo copyFrom(Object sourceObj) {
		if (isCart(sourceObj))
			return copyFromCart(sourceObj);
		
		return copyFrom(sourceObj, TotAmountInfo.class);
	}
	
	
	
	public static List<TotAmountInfo> copyFrom(List<?> sourceObjs) {
		if (isCart(sourceObjs))
			return copyFromCart(sourceObjs);
		
		return copyFrom(sourceObjs, TotAmountInfo.class);
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
	private static List<TotAmountInfo> copyFromCart(List<?> sourceObjs) {
		return new TotAmountCopyCart().makeCopy( (List<CartInfo>)sourceObjs);
	}
	
	
	
	private static TotAmountInfo copyFromCart(Object sourceObj) {
		return new TotAmountCopyCart().makeCopy( (CartInfo)sourceObj);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return (TotAmountInfo) super.clone();
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
		
		
		if (!(o instanceof TotAmountInfo))
			return false;
		
		
		TotAmountInfo obj = (TotAmountInfo) o;		
		return (amount       == obj.amount       && 
				decimalPlace == obj.decimalPlace &&
				codCurr.equals(obj.codCurr));
	}
}
