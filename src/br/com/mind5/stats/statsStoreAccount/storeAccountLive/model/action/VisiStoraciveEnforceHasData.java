package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveSetterHasData;

final class VisiStoraciveEnforceHasData extends ActionVisitorTemplateEnforce<StoraciveInfo> {
	
	public VisiStoraciveEnforceHasData(DeciTreeOption<StoraciveInfo> option) {
		super(option);
	}

	
	
	@Override protected StoraciveInfo enforceHook(StoraciveInfo recordInfo) {
		InfoSetter<StoraciveInfo> attrSetter = new StoraciveSetterHasData();
		return attrSetter.setAttr(recordInfo);
	}
}
