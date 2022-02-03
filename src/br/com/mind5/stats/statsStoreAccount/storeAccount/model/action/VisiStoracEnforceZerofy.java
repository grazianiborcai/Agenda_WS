package br.com.mind5.stats.statsStoreAccount.storeAccount.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracSetterZerofy;

final class VisiStoracEnforceZerofy extends ActionVisitorTemplateEnforce<StoracInfo> {
	
	public VisiStoracEnforceZerofy(DeciTreeOption<StoracInfo> option) {
		super(option);
	}

	
	
	@Override protected StoracInfo enforceHook(StoracInfo recordInfo) {
		InfoSetter<StoracInfo> attrSetter = new StoracSetterZerofy();
		return attrSetter.setAttr(recordInfo);
	}
}
