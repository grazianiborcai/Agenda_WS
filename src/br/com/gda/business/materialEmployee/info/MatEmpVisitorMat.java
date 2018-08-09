package br.com.gda.business.materialEmployee.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatEmpVisitorMat implements InfoMergerVisitor<MatEmpInfo, MatInfo, MatEmpInfo> {

	@Override public MatEmpInfo mergeRecord(MatInfo sourceOne, MatEmpInfo sourceTwo) {
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
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codMat != sourceTwo.codMat)
			throw new IllegalArgumentException("codMat" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
}
