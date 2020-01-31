package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpmatVisiMergeMatlis implements InfoMergerVisitor_<EmpmatInfo, MatlisInfo> {

	@Override public EmpmatInfo writeRecord(MatlisInfo sourceOne, EmpmatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		sourceTwo.matlisData = sourceOne;
		return sourceTwo;
	}
	
	
	
	private void checkArgument(MatlisInfo sourceOne, EmpmatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(MatlisInfo sourceOne, EmpmatInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codMat   == sourceTwo.codMat);
	}
}
