package br.com.mind5.stats.statsUserAccount.userAccount.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracSetterZerofy;

final class VisiSuseracEnforceZerofy extends ActionVisitorTemplateEnforce<SuseracInfo> {
	
	public VisiSuseracEnforceZerofy(DeciTreeOption<SuseracInfo> option) {
		super(option);
	}

	
	
	@Override protected SuseracInfo enforceHook(SuseracInfo recordInfo) {
		InfoSetter<SuseracInfo> attrSetter = new SuseracSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
