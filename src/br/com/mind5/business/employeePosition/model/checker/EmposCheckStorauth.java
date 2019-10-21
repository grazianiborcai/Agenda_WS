package br.com.mind5.business.employeePosition.model.checker;

import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.model.checker.StorauthCheckExist;

public final class EmposCheckStorauth implements ModelChecker<EmposInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StorauthInfo> checker;
	
	
	public EmposCheckStorauth(ModelCheckerOption option) {
		checker = new StorauthCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmposInfo> recordInfos) {
		for (EmposInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmposInfo recordInfo) {
		return checker.check(StorauthInfo.copyFrom(recordInfo));
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
