package br.com.mind5.business.materialMovement.model.checker;

import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class MatmovCheckDummy implements ModelChecker<MatmovInfo> {
	private ModelChecker<MatmovInfo> checker;
	
	
	public MatmovCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<MatmovInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(MatmovInfo recordInfo) {
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
