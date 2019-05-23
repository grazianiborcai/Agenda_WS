package br.com.gda.business.cartItem.info;

import br.com.gda.business.masterData.info.common.CartCateg;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class CartemVisiMergeTotAmount implements InfoMergerVisitorV2<CartemInfo, TotAmountInfo> {

	@Override public CartemInfo writeRecord(TotAmountInfo sourceOne, CartemInfo sourceTwo) {	
		checkArgument(sourceOne, sourceTwo);
		
		CartemInfo resultInfo = new CartemInfo();
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
	
	
	
	private void checkArgument(TotAmountInfo sourceOne, CartemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}

	
	
	@Override public boolean shouldWrite(TotAmountInfo sourceOne, CartemInfo sourceTwo) {
		return true;
	}
}
