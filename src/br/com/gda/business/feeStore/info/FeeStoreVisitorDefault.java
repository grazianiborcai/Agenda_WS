package br.com.gda.business.feeStore.info;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoWriteVisitor;

final class FeeStoreVisitorDefault implements InfoWriteVisitor<FeeStoreInfo, FeeDefaultInfo, FeeStoreInfo> {

	@Override public FeeStoreInfo writeRecord(FeeDefaultInfo sourceOne, FeeStoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		FeeStoreInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codCurr = sourceOne.codCurr;
		resultInfo.price = sourceOne.price;

		return resultInfo;
	}
	
	
	
	private void checkArgument(FeeDefaultInfo sourceOne, FeeStoreInfo sourceTwo) {
		if (sourceOne.codFeeCateg != sourceTwo.codFeeCateg)
			throw new IllegalArgumentException("codFeeCateg" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private FeeStoreInfo makeClone(FeeStoreInfo recordInfo) {
		try {
			return (FeeStoreInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
