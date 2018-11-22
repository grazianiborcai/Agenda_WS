package br.com.gda.business.materialEmployee.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatEmpVisitorMat implements InfoMergerVisitor<MatEmpInfo, MatInfo, MatEmpInfo> {

	@Override public MatEmpInfo writeRecord(MatInfo sourceOne, MatEmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatEmpInfo resultInfo = MatEmpInfo.copyFrom(sourceTwo);
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
	
	
	
	private void checkArgument(MatInfo sourceOne, MatEmpInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(MatInfo sourceOne, MatEmpInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codMat == sourceTwo.codMat);
	}
}
