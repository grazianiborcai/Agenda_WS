package br.com.gda.business.materialStore.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatStoreVisitorMat implements InfoMergerVisitor<MatStoreInfo, MatInfo, MatStoreInfo> {

	@Override public MatStoreInfo writeRecord(MatInfo sourceOne, MatStoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatStoreInfo resultInfo = MatStoreInfo.copyFrom(sourceTwo);
		resultInfo.txtMat = sourceOne.txtMat;
		resultInfo.codType = sourceOne.codType;
		resultInfo.txtType = sourceOne.txtType;
		resultInfo.codCategory = sourceOne.codCategory;
		resultInfo.txtCategory = sourceOne.txtCategory;
		resultInfo.priceUnit = sourceOne.priceUnit;
		resultInfo.codUnit = sourceOne.codUnit;
		resultInfo.txtUnit = sourceOne.txtUnit;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, MatStoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(MatInfo sourceOne, MatStoreInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codMat == sourceTwo.codMat);
	}
}
