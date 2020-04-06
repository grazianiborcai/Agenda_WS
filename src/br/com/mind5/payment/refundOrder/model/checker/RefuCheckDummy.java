package br.com.mind5.payment.refundOrder.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class RefuCheckDummy implements ModelCheckerV1<RefuInfo> {
	private ModelCheckerV1<RefuInfo> checker;
	
	
	public RefuCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<RefuInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(RefuInfo recordInfo) {
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
