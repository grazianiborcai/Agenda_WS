package br.com.gda.business.cart.info;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CartVisitorCateg implements InfoMergerVisitor<CartInfo, CartCategInfo, CartInfo> {

	@Override public CartInfo writeRecord(CartCategInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtItemCateg = sourceOne.txtItemCateg;

		return resultInfo;
	}
	
	
	
	private void checkArgument(CartCategInfo sourceOne, CartInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(CartCategInfo sourceOne, CartInfo sourceTwo) {
		return (sourceOne.codItemCateg == sourceTwo.codItemCateg);
	}
}
