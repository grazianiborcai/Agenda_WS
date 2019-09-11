package br.com.gda.file.filePath.model.checker;

import java.util.List;

import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class FathCheckDummy implements ModelChecker<FathInfo> {
	private ModelChecker<FathInfo> helper;
	
	
	public FathCheckDummy() {
		helper = new ModelCherckerTrue<>();
	}

	
	@Override public boolean check(List<FathInfo> recordInfos) {
		return helper.check(recordInfos);
	}


	
	@Override public boolean check(FathInfo recordInfo) {
		return helper.check(recordInfo);
	}


	
	@Override public boolean getResult() {
		return helper.getResult();
	}


	
	@Override public String getFailMessage() {
		return helper.getFailMessage();
	}


	
	@Override public int getFailCode() {
		return helper.getFailCode();
	}
}
