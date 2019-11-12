package br.com.mind5.business.employeeWorkTimeConflict.model.checker;

import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckExist;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class EmpwocoCheckEmpos implements ModelChecker<EmpwocoInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmposInfo> checker;
	
	
	public EmpwocoCheckEmpos(ModelCheckerOption option) {
		checker = new EmposCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmpwocoInfo> recordInfos) {
		for (EmpwocoInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpwocoInfo recordInfo) {
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
