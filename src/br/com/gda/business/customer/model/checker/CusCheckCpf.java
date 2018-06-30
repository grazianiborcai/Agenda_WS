package br.com.gda.business.customer.model.checker;

import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerCpf;

public final class CusCheckCpf implements ModelChecker<CusInfo> {
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	
	private ModelChecker<String> checkerCpf;
	
	public CusCheckCpf() {
		checkerCpf = new ModelCheckerCpf();
	}

	
	
	@Override public boolean check(List<CusInfo> recordInfos) {
		for (CusInfo eachCusInfo : recordInfos) {
			if (check(eachCusInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(CusInfo recordInfo) {
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
