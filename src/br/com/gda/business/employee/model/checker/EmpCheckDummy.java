package br.com.gda.business.employee.model.checker;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class EmpCheckDummy implements ModelChecker<EmpInfo> {
	private ModelChecker<EmpInfo> checker;
	
	
	public EmpCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<EmpInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(EmpInfo recordInfo) {
		return checker.check(recordInfo);
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
