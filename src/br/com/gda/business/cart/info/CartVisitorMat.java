package br.com.gda.business.cart.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CartVisitorMat implements InfoMergerVisitor<CartInfo, MatInfo, CartInfo> {

	@Override public CartInfo writeRecord(MatInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtMat = sourceOne.txtMat;
		resultInfo.codUnit = sourceOne.codUnit;
		resultInfo.txtUnit = sourceOne.txtUnit;
		resultInfo.priceUnit = sourceOne.priceUnit;
		resultInfo.price = sourceOne.price;
		resultInfo.codCurr = sourceOne.codCurr;
		resultInfo.txtCurr = sourceOne.txtCurr;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, CartInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codMat != sourceTwo.codMat)
			throw new IllegalArgumentException("codMat" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}

