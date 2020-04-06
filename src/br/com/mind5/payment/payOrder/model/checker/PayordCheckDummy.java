package br.com.mind5.payment.payOrder.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckDummy implements ModelCheckerV1<PayordInfo> {
	private ModelCheckerV1<PayordInfo> checker;
	
	
	public PayordCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PayordInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PayordInfo recordInfo) {
		return checker.check(recordInfo);
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
