package br.com.mind5.business.employeeWorkTime.model.checker;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.checker.StowotmCheckSWT_;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class EmpwotmCheckStowotm implements ModelChecker<EmpwotmInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StowotmInfo> checker;
	
	
	public EmpwotmCheckStowotm(ModelCheckerOption option) {
		checker = new StowotmCheckSWT_(option);
	}
	
	
	
	@Override public boolean check(List<EmpwotmInfo> recordInfos) {
		for (EmpwotmInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpwotmInfo recordInfo) {
		return checker.check(StowotmInfo.copyFrom(recordInfo));
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
