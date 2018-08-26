package br.com.gda.business.cart.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoWriteVisitor;

final class CartVisitorStore implements InfoWriteVisitor<CartInfo, StoreInfo, CartInfo> {

	@Override public CartInfo writeRecord(StoreInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = makeClone(sourceTwo);
		resultInfo.nameStore = sourceOne.name;
		resultInfo.codTimezone = sourceOne.codTimezone;

		return resultInfo;
	}
	
	
	
	private void checkArgument(StoreInfo sourceOne, CartInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codStore != sourceTwo.codStore)
			throw new IllegalArgumentException("codStore" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
