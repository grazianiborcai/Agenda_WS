package br.com.gda.business.cartSnapshot.info;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class CartSnapVisitorCart implements InfoMergerVisitor_<CartSnapInfo, CartemInfo, CartSnapInfo> {

	@Override public CartSnapInfo writeRecord(CartemInfo sourceOne, CartSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartSnapInfo resultInfo = CartSnapInfo.copyFrom(sourceOne);
		resultInfo.codSnapshot = sourceTwo.codSnapshot;
		return resultInfo;
	}
	
	
	
	private void checkArgument(CartemInfo sourceOne, CartSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(CartemInfo sourceOne, CartSnapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codUser  == sourceTwo.codUser			);
	}
}
