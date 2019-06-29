package br.com.gda.payment.creditCard.model.checker;

import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.checker.UsernameCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CrecardCheckUsername implements ModelChecker<CrecardInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<UsernameInfo> checker;
	
	
	public CrecardCheckUsername(ModelCheckerOption option) {
		checker = new UsernameCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CrecardInfo> recordInfos) {
		for (CrecardInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CrecardInfo recordInfo) {
		return checker.check(UsernameCopier.copyFromCrecard(recordInfo));
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
