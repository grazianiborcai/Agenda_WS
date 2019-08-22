package br.com.gda.business.cart.info;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CartVisiMergeCartem implements InfoMergerVisitor<CartInfo, CartemInfo> {

	@Override public CartInfo writeRecord(CartemInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CartemInfo sourceOne, CartInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CartInfo merge(CartemInfo sourceOne, CartInfo sourceTwo) {
		sourceTwo.cartems.add(sourceOne);
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CartemInfo sourceOne, CartInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codUser  == sourceTwo.codUser		);
	}
}
