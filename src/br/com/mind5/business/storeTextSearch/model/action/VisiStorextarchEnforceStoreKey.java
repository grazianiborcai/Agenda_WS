package br.com.mind5.business.storeTextSearch.model.action;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.info.StorextarchSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextarchEnforceStoreKey extends ActionVisitorTemplateEnforce<StorextarchInfo> {
	
	public VisiStorextarchEnforceStoreKey(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StorextarchInfo enforceHook(StorextarchInfo recordInfo) {
		InfoSetter<StorextarchInfo> attrSetter = new StorextarchSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
