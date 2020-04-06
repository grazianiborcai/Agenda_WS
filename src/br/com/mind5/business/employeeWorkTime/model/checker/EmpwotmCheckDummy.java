package br.com.mind5.business.employeeWorkTime.model.checker;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class EmpwotmCheckDummy implements ModelCheckerV1<EmpwotmInfo> {
	private ModelCheckerV1<EmpwotmInfo> checker;
	
	
	public EmpwotmCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<EmpwotmInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(EmpwotmInfo recordInfo) {
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
