package br.com.gda.business.employee.model.checker;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.checker.EmpmatCheckHasEmpItem;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmpCheckHasEmpmat implements ModelChecker<EmpInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmpmatInfo> checker;
	
	
	public EmpCheckHasEmpmat(ModelCheckerOption option) {
		checker = new EmpmatCheckHasEmpItem(option);
	}
	
	
	
	@Override public boolean check(List<EmpInfo> recordInfos) {
		for (EmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpInfo recordInfo) {
		return checker.check(EmpmatInfo.copyFrom(recordInfo));
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
