package br.com.gda.business.cart.info;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.masterData.info.CartCateg;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CartVisitorFee implements InfoMergerVisitor<CartInfo, FeeStoreInfo, CartInfo> {

	@Override public CartInfo writeRecord(FeeStoreInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = CartInfo.copyFrom(sourceOne);
		resultInfo.codItemCateg = CartCateg.SERVICE_FEE.getCodCateg();	//TODO: deve ficar aqui ou criar um Action ?
		resultInfo.priceUnit = 1;
		resultInfo.quantity = 1;

		return resultInfo;
	}
	
	
	
	private void checkArgument(FeeStoreInfo sourceOne, CartInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codStore != sourceTwo.codStore)
			throw new IllegalArgumentException("codStore" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
}
