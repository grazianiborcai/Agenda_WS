package br.com.gda.business.masterData.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class SysEnvironCheckRead implements ModelChecker<SysEnvironInfo> {
	private ModelCherckerTrue<SysEnvironInfo> helper;
	

	public SysEnvironCheckRead() {
		helper = new ModelCherckerTrue<>();
	}


	
	@Override public boolean check(List<SysEnvironInfo> recordInfos) {
		return helper.check(recordInfos);
	}



	@Override public boolean check(SysEnvironInfo recordInfo) {
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
