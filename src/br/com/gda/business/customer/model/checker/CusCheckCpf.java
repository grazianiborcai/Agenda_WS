package br.com.gda.business.customer.model.checker;

import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerCpf;

public final class CusCheckCpf implements ModelChecker<CusInfo> {
	private final boolean SUCCESS = true;
	private final boolean FAILED = false;
	
	private ModelChecker<String> checkerCpf;
	
	public CusCheckCpf() {
		checkerCpf = new ModelCheckerCpf();
	}

	
	
	@Override public boolean check(List<CusInfo> recordInfos) {
		for (CusInfo eachCusInfo : recordInfos) {
			if (check(eachCusInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CusInfo recordInfo) {
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
