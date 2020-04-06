package br.com.mind5.file.filePath.model.checker;

import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class FathCheckDummy implements ModelCheckerV1<FathInfo> {
	private ModelCheckerV1<FathInfo> helper;
	
	
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
