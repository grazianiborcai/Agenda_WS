package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmpmatVisiMergeMat implements InfoMergerVisitor<EmpmatInfo, MatInfo> {

	@Override public EmpmatInfo writeRecord(MatInfo sourceOne, EmpmatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		sourceTwo.matData = sourceOne;
		return sourceTwo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, EmpmatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(MatInfo sourceOne, EmpmatInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codMat == sourceTwo.codMat);
	}
}
