package br.com.gda.business.cartItem.info;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.masterData.info.common.CartCateg;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class CartemVisiMergeFeeDefault implements InfoMergerVisitorV2<CartemInfo, FeeDefaultInfo> {

	@Override public CartemInfo writeRecord(FeeDefaultInfo sourceOne, CartemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartemInfo resultInfo = CartemInfo.copyFrom(sourceOne);
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
	
	
	
	private void checkArgument(FeeDefaultInfo sourceOne, CartemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(FeeDefaultInfo sourceOne, CartemInfo sourceTwo) {
		return true;
	}
}
