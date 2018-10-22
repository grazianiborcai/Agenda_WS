package br.com.gda.business.cart.info;

import br.com.gda.business.masterData.info.CartCateg;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.info.InfoMergerVisitor;

final class CartVisitorTotAmount implements InfoMergerVisitor<CartInfo, TotAmountInfo, CartInfo> {

	@Override public CartInfo writeRecord(TotAmountInfo sourceOne, CartInfo sourceTwo) {		
		CartInfo resultInfo = new CartInfo();
		resultInfo.codOwner = sourceTwo.codOwner;
		resultInfo.codCustomer = sourceTwo.codCustomer;
		
		resultInfo.price = sourceOne.amount;
		resultInfo.codCurr = sourceOne.codCurr;
		resultInfo.quantity = 1;
		
		resultInfo.codItemCateg = CartCateg.TOTAL.getCodCateg();

		return resultInfo;
	}
}
