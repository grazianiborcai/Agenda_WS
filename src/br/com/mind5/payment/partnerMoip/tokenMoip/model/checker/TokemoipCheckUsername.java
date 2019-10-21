package br.com.mind5.payment.partnerMoip.tokenMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.checker.UsernameCheckExist;

public final class TokemoipCheckUsername implements ModelChecker<TokemoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<UsernameInfo> checker;
	
	
	public TokemoipCheckUsername(ModelCheckerOption option) {
		checker = new UsernameCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<TokemoipInfo> recordInfos) {
		for (TokemoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(TokemoipInfo recordInfo) {
		return checker.check(UsernameCopier.copyFromTokemoip(recordInfo));
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
