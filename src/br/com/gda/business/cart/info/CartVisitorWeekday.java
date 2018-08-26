package br.com.gda.business.cart.info;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoWriteVisitor;

final class CartVisitorWeekday implements InfoWriteVisitor<CartInfo, WeekdayInfo, CartInfo> {

	@Override public CartInfo writeRecord(WeekdayInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtWeekday = sourceOne.txtWeekday;

		return resultInfo;
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, CartInfo sourceTwo) {
		if (sourceOne.codWeekday != sourceTwo.codWeekday)
			throw new IllegalArgumentException("codWeekday" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
