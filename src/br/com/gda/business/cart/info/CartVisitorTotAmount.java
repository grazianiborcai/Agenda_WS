package br.com.gda.business.cart.info;

import br.com.gda.business.masterData.info.common.CartCateg;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class CartVisitorTotAmount implements InfoMergerVisitor_<CartInfo, TotAmountInfo, CartInfo> {

	@Override public CartInfo writeRecord(TotAmountInfo sourceOne, CartInfo sourceTwo) {	
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = new CartInfo();
		resultInfo.codOwner = sourceTwo.codOwner;
		resultInfo.codCustomer = sourceTwo.codCustomer;
		resultInfo.codUser = sourceTwo.codUser;
		resultInfo.codPerson = sourceTwo.codPerson;
		resultInfo.codLanguage = sourceTwo.codLanguage;
		
		resultInfo.price = sourceOne.amount;
		resultInfo.codCurr = sourceOne.codCurr;
		resultInfo.quantity = 1;
		
		resultInfo.codItemCateg = CartCateg.TOTAL.getCodCateg();

		return resultInfo;
	}
	
	
	
	private void checkArgument(TotAmountInfo sourceOne, CartInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}

	
	
	@Override public boolean shouldWrite(TotAmountInfo sourceOne, CartInfo sourceTwo) {
		return true;
	}
}
