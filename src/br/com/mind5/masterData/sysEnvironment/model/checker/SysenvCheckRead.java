package br.com.mind5.masterData.sysEnvironment.model.checker;

import java.util.List;

import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class SysenvCheckRead implements ModelCheckerV1<SysenvInfo> {
	private ModelCherckerTrue<SysenvInfo> helper;
	

	public SysenvCheckRead() {
		helper = new ModelCherckerTrue<>();
	}


	
	@Override public boolean check(List<SysenvInfo> recordInfos) {
		return helper.check(recordInfos);
	}



	@Override public boolean check(SysenvInfo recordInfo) {
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
