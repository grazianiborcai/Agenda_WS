package br.com.mind5.payment.storePartner.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparCheckStorauth implements ModelCheckerV1<StoparInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<StorauthInfo> checker;
	
	
	public StoparCheckStorauth(ModelCheckerOption option) {
		checker = new StorauthCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoparInfo> recordInfos) {
		for (StoparInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoparInfo recordInfo) {
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
