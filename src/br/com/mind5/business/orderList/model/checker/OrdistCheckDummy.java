package br.com.mind5.business.orderList.model.checker;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class OrdistCheckDummy implements ModelCheckerV1<OrdistInfo> {
	private ModelCheckerV1<OrdistInfo> checker;
	
	
	public OrdistCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<OrdistInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(OrdistInfo recordInfo) {
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
