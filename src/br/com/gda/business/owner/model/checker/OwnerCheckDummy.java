package br.com.gda.business.owner.model.checker;

import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class OwnerCheckDummy implements ModelChecker<OwnerInfo> {
	private ModelChecker<OwnerInfo> checker;
	
	
	public OwnerCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<OwnerInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(OwnerInfo recordInfo) {
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
