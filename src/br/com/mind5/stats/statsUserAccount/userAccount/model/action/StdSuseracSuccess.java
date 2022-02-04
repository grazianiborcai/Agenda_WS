package br.com.mind5.stats.statsUserAccount.userAccount.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;

public final class StdSuseracSuccess extends ActionStdSuccessTemplate<SuseracInfo> {
	
	public StdSuseracSuccess(DeciTreeOption<SuseracInfo> option) {
		super(option);
	}
}
