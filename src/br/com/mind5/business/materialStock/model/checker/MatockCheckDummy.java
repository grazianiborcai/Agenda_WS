package br.com.mind5.business.materialStock.model.checker;

import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class MatockCheckDummy implements ModelCheckerV1<MatockInfo> {
	private ModelCheckerV1<MatockInfo> checker;
	
	
	public MatockCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<MatockInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(MatockInfo recordInfo) {
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
