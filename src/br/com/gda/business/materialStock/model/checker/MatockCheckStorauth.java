package br.com.gda.business.materialStock.model.checker;

import java.util.List;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.model.checker.StorauthCheckExist;

public final class MatockCheckStorauth implements ModelChecker<MatockInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StorauthInfo> checker;
	
	
	public MatockCheckStorauth(ModelCheckerOption option) {
		checker = new StorauthCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatockInfo> recordInfos) {
		for (MatockInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatockInfo recordInfo) {
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
