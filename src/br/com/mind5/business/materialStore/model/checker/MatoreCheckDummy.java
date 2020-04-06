package br.com.mind5.business.materialStore.model.checker;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class MatoreCheckDummy implements ModelCheckerV1<MatoreInfo> {
	private ModelCheckerV1<MatoreInfo> checker;
	
	
	public MatoreCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<MatoreInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(MatoreInfo recordInfo) {
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
