package br.com.gda.business.cartSnapshot.info;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CartSnapVisitorCart implements InfoMergerVisitor<CartSnapInfo, CartInfo, CartSnapInfo> {

	@Override public CartSnapInfo writeRecord(CartInfo sourceOne, CartSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartSnapInfo resultInfo = CartSnapInfo.copyFrom(sourceOne);
		resultInfo.codSnapshot = sourceTwo.codSnapshot;
		return resultInfo;
	}
	
	
	
	private void checkArgument(CartInfo sourceOne, CartSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(CartInfo sourceOne, CartSnapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codUser  == sourceTwo.codUser			);
	}
}
