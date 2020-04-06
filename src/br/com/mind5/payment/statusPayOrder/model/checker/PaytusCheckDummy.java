package br.com.mind5.payment.statusPayOrder.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class PaytusCheckDummy implements ModelCheckerV1<PaytusInfo> {
	private ModelCheckerV1<PaytusInfo> checker;
	
	
	public PaytusCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PaytusInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PaytusInfo recordInfo) {
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
