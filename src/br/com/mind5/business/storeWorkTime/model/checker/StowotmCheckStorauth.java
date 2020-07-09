package br.com.mind5.business.storeWorkTime.model.checker;

import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckAuthorization;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class StowotmCheckStorauth implements ModelCheckerV1<StowotmInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<StorauthInfo> checker;
	
	
	public StowotmCheckStorauth(ModelCheckerOption option) {
		checker = new StorauthCheckAuthorization(option);
	}
	
	
	
	@Override public boolean check(List<StowotmInfo> recordInfos) {
		for (StowotmInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StowotmInfo recordInfo) {
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
