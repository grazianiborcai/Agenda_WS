package br.com.gda.business.employee.model.checker;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCheckerCpf_;

public final class EmpCheckCpf implements ModelChecker<EmpInfo> {
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	
	private ModelChecker<String> checkerCpf;
	
	public EmpCheckCpf() {
		checkerCpf = new ModelCheckerCpf_();
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

	
	
	@Override public String getFailMessage() {
		return checkerCpf.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checkerCpf.getFailCode();
	}
}
