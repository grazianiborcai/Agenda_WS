package br.com.gda.file.fileImage.model.checker;

import java.util.List;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class FimgCheckDummy implements ModelChecker<FimgInfo> {
	private ModelChecker<FimgInfo> helper;
	
	
	public FimgCheckDummy() {
		helper = new ModelCherckerTrue<>();
	}

	
	@Override public boolean check(List<FimgInfo> recordInfos) {
		return helper.check(recordInfos);
	}


	
	@Override public boolean check(FimgInfo recordInfo) {
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
