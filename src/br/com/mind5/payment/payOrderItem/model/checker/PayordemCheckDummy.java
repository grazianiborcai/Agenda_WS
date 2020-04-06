package br.com.mind5.payment.payOrderItem.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckDummy implements ModelCheckerV1<PayordemInfo> {
	private ModelCheckerV1<PayordemInfo> checker;
	
	
	public PayordemCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PayordemInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PayordemInfo recordInfo) {
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
