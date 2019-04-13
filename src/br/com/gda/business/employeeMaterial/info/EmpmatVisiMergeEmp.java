package br.com.gda.business.employeeMaterial.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class EmpmatVisiMergeEmp implements InfoMergerVisitor<EmpmatInfo, EmpInfo, EmpmatInfo> {

	@Override public EmpmatInfo writeRecord(EmpInfo sourceOne, EmpmatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		EmpmatInfo resultInfo = EmpmatInfo.copyFrom(sourceTwo);
		resultInfo.nameEmployee = "sourceOne.name";		//TODO: Ajustar

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmpInfo sourceOne, EmpmatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(EmpInfo sourceOne, EmpmatInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codEmployee == sourceTwo.codEmployee);
	}
}
