package br.com.mind5.business.material.model.checker;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class MatCheckDummy implements ModelChecker<MatInfo> {
	private ModelChecker<MatInfo> checker;
	
	
	public MatCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<MatInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(MatInfo recordInfo) {
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
