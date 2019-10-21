package br.com.mind5.payment.partnerMoip.permissionMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class PeresmoipCheckUsername implements ModelChecker<PeresmoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<UsernameInfo> checker;
	
	
	public PeresmoipCheckUsername(ModelCheckerOption option) {
		checker = new UsernameCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PeresmoipInfo> recordInfos) {
		for (PeresmoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PeresmoipInfo recordInfo) {
		return checker.check(UsernameInfo.copyFrom(recordInfo));
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
