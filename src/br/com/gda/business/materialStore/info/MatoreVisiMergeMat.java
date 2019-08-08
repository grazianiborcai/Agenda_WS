package br.com.gda.business.materialStore.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatoreVisiMergeMat implements InfoMergerVisitor<MatoreInfo, MatInfo> {

	@Override public MatoreInfo writeRecord(MatInfo sourceOne, MatoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatoreInfo resultInfo = MatoreInfo.copyFrom(sourceTwo);
		resultInfo.txtMat = sourceOne.txtMat;
		resultInfo.codType = sourceOne.codType;
		resultInfo.txtType = sourceOne.txtType;
		resultInfo.codMatCateg = sourceOne.codMatCateg;
		resultInfo.txtMatCateg = sourceOne.txtMatCateg;
		resultInfo.priceUnit = sourceOne.priceUnit;
		resultInfo.codUnit = sourceOne.codUnit;
		resultInfo.txtUnit = sourceOne.txtUnit;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, MatoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(MatInfo sourceOne, MatoreInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codMat == sourceTwo.codMat);
	}
}
