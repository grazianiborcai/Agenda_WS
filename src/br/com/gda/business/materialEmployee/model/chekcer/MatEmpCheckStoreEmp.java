package br.com.gda.business.materialEmployee.model.chekcer;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.model.checker.EmposCheckExist;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class MatEmpCheckStoreEmp implements ModelChecker<MatEmpInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmposInfo> checker;
	
	
	public MatEmpCheckStoreEmp(ModelCheckerOption option) {
		checker = new EmposCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatEmpInfo> recordInfos) {
		for (MatEmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatEmpInfo recordInfo) {
		return checker.check(EmposInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
