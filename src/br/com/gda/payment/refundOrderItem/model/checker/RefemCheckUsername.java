package br.com.gda.payment.refundOrderItem.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.checker.UsernameCheckExist;

public final class RefemCheckUsername implements ModelChecker<RefemInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<UsernameInfo> checker;
	
	
	public RefemCheckUsername(ModelCheckerOption option) {
		checker = new UsernameCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<RefemInfo> recordInfos) {
		for (RefemInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(RefemInfo recordInfo) {
		return checker.check(UsernameCopier.copyFromRefem(recordInfo));
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
