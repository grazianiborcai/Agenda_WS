package br.com.mind5.business.storeLeaveDateSearch.model.checker;

import java.util.List;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.checker.LanguCheckExist;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class StolarchCheckLangu implements ModelChecker<StolarchInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<LanguInfo> checker;
	
	
	public StolarchCheckLangu(ModelCheckerOption option) {
		checker = new LanguCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StolarchInfo> recordInfos) {
		for (StolarchInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StolarchInfo recordInfo) {
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
