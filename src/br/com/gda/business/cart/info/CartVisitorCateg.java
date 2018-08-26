package br.com.gda.business.cart.info;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoWriteVisitor;

final class CartVisitorCateg implements InfoWriteVisitor<CartInfo, CartCategInfo, CartInfo> {

	@Override public CartInfo writeRecord(CartCategInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtItemCateg = sourceOne.txtItemCateg;

		return resultInfo;
	}
	
	
	
	private void checkArgument(CartCategInfo sourceOne, CartInfo sourceTwo) {
		if (sourceOne.codItemCateg != sourceTwo.codItemCateg)
			throw new IllegalArgumentException("codItemCateg" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
