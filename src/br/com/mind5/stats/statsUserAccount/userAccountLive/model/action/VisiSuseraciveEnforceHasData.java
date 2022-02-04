package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveSetterHasData;

final class VisiSuseraciveEnforceHasData extends ActionVisitorTemplateEnforce<SuseraciveInfo> {
	
	public VisiSuseraciveEnforceHasData(DeciTreeOption<SuseraciveInfo> option) {
		super(option);
	}

	
	
	@Override protected SuseraciveInfo enforceHook(SuseraciveInfo recordInfo) {
		InfoSetter<SuseraciveInfo> attrSetter = new SuseraciveSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
