package br.com.mind5.business.employeePositionSearch.model.checker;

import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class EmposarchCheckLangu implements ModelChecker<EmposarchInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<LanguInfo> checker;
	
	
	public EmposarchCheckLangu(ModelCheckerOption option) {
		checker = new LanguCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmposarchInfo> recordInfos) {
		for (EmposarchInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmposarchInfo recordInfo) {
		return checker.check(LanguInfo.copyFrom(recordInfo));
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
