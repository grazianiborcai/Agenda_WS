package br.com.gda.business.materialEmployee.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatEmpVisitorEmp implements InfoMergerVisitor<MatEmpInfo, EmpInfo, MatEmpInfo> {

	@Override public MatEmpInfo mergeRecord(EmpInfo sourceOne, MatEmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatEmpInfo resultInfo = MatEmpInfo.copyFrom(sourceTwo);
		resultInfo.nameEmployee = sourceOne.name;

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmpInfo sourceOne, MatEmpInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codEmployee != sourceTwo.codEmployee)
			throw new IllegalArgumentException("codEmployee" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
}
