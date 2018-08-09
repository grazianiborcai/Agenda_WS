package br.com.gda.business.materialStore.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatStoreVisitorMat implements InfoMergerVisitor<MatStoreInfo, MatInfo, MatStoreInfo> {

	@Override public MatStoreInfo mergeRecord(MatInfo sourceOne, MatStoreInfo sourceTwo) {
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
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codMat != sourceTwo.codMat)
			throw new IllegalArgumentException("codMat" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
}
