package br.com.mind5.file.fileImage.model.checker;

import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class FimgCheckDummy implements ModelCheckerV1<FimgInfo> {
	private ModelCheckerV1<FimgInfo> helper;
	
	
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
