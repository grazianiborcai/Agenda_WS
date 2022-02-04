package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveSetterHasData;

final class VisiUseraciveEnforceHasData extends ActionVisitorTemplateEnforce<UseraciveInfo> {
	
	public VisiUseraciveEnforceHasData(DeciTreeOption<UseraciveInfo> option) {
		super(option);
	}

	
	
	@Override protected UseraciveInfo enforceHook(UseraciveInfo recordInfo) {
		InfoSetter<UseraciveInfo> attrSetter = new UseraciveSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
