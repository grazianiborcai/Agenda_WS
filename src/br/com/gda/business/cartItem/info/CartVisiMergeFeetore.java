package br.com.gda.business.cartItem.info;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.masterData.info.common.CartCateg;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;;

final class CartVisiMergeFeetore implements InfoMergerVisitorV2<CartInfo, FeetoreInfo> {

	@Override public CartInfo writeRecord(FeetoreInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = CartInfo.copyFrom(sourceOne);
		resultInfo.codOwner = sourceTwo.codOwner;	
		resultInfo.codCustomer = sourceTwo.codCustomer;
		resultInfo.codUser = sourceTwo.codUser;
		resultInfo.codPerson = sourceTwo.codPerson;
		resultInfo.codCurr = sourceTwo.codCurr;
		resultInfo.codLanguage = sourceTwo.codLanguage;
		resultInfo.codItemCateg = CartCateg.SERVICE_FEE.getCodCateg();	//TODO: deve ficar aqui ou criar um Action ?
		resultInfo.priceUnit = 1;
		resultInfo.quantity = 1;

		return resultInfo;
	}
	
	
	
	private void checkArgument(FeetoreInfo sourceOne, CartInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(FeetoreInfo sourceOne, CartInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codStore == sourceTwo.codStore);
	}
}
