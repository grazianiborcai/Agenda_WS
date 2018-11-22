package br.com.gda.business.materialEmployee.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatEmpVisitorEmp implements InfoMergerVisitor<MatEmpInfo, EmpInfo, MatEmpInfo> {

	@Override public MatEmpInfo writeRecord(EmpInfo sourceOne, MatEmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatEmpInfo resultInfo = MatEmpInfo.copyFrom(sourceTwo);
		resultInfo.nameEmployee = sourceOne.name;

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmpInfo sourceOne, MatEmpInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(EmpInfo sourceOne, MatEmpInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codEmployee == sourceTwo.codEmployee);
	}
}
