package br.com.gda.security.storeAuthorization.model.checker;

import java.util.List;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.business.ownerStore_.model.checker.OwntoreCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;

public final class StorauthCheckOwntore implements ModelChecker<StorauthInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<OwntoreInfo> checker;
	
	
	public StorauthCheckOwntore(ModelCheckerOption option) {
		checker = new OwntoreCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StorauthInfo> recordInfos) {
		for (StorauthInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(StorauthInfo recordInfo) {
		return checker.check(OwntoreInfo.copyFrom(recordInfo));
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
