package br.com.mind5.file.fileImageList.model.checker;

import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class FimistCheckDummy implements ModelCheckerV1<FimistInfo> {
	private ModelCheckerV1<FimistInfo> helper;
	
	
	public FimistCheckDummy() {
		helper = new ModelCherckerTrue<>();
	}

	
	@Override public boolean check(List<FimistInfo> recordInfos) {
		return helper.check(recordInfos);
	}


	
	@Override public boolean check(FimistInfo recordInfo) {
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
