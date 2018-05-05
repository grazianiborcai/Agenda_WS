package br.com.gda.business.employee.model.checker;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerCpf;

public final class CheckerEmpCpf implements ModelChecker<EmpInfo> {
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	
	private ModelChecker<String> checkerCpf;
	
	public CheckerEmpCpf() {
		checkerCpf = new ModelCheckerCpf();
	}

	
	
	@Override public boolean check(List<EmpInfo> recordInfos) {
		for (EmpInfo eachEmpInfo : recordInfos) {
			if (check(eachEmpInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(EmpInfo recordInfo) {
		return checkerCpf.check(recordInfo.cpf);
	}

	
	
	@Override public boolean getResult() {
		return checkerCpf.getResult();
	}

	
	
	@Override public String getFailureExplanation() {
		return checkerCpf.getFailureExplanation();
	}

	
	
	@Override public int getFailureCode() {
		return checkerCpf.getFailureCode();
	}
}
