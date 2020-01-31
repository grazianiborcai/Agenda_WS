package br.com.mind5.business.employeeMaterial.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpmatVisiMergeEmplis implements InfoMergerVisitor_<EmpmatInfo, EmplisInfo> {

	@Override public EmpmatInfo writeRecord(EmplisInfo sourceOne, EmpmatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
			
		sourceTwo.emplisData = sourceOne;
		return sourceTwo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, EmpmatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(EmplisInfo sourceOne, EmpmatInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner && 
			    sourceOne.codEmployee == sourceTwo.codEmployee	);
	}
}
