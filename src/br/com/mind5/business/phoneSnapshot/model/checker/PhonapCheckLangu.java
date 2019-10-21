package br.com.mind5.business.phoneSnapshot.model.checker;

import java.util.List;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.checker.LanguCheckExist;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class PhonapCheckLangu implements ModelChecker<PhonapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<LanguInfo> checker;
	
	
	public PhonapCheckLangu(ModelCheckerOption option) {
		checker = new LanguCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PhonapInfo> recordInfos) {
		for (PhonapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PhonapInfo recordInfo) {
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
