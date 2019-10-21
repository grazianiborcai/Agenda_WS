package br.com.mind5.business.companySnapshot.model.checker;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.checker.CompCheckExist;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class CompnapCheckComp implements ModelChecker<CompnapInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<CompInfo> checker;
	
	
	public CompnapCheckComp(ModelCheckerOption option) {
		checker = new CompCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CompnapInfo> recordInfos) {
		for (CompnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(CompnapInfo recordInfo) {
		return checker.check(CompInfo.copyFrom(recordInfo));
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
