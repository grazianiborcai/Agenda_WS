package br.com.mind5.business.storeTextSearch.model.action;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.info.StorextarchSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextarchEnforceStoreKey extends ActionVisitorTemplateEnforceV2<StorextarchInfo> {
	
	public VisiStorextarchEnforceStoreKey(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StorextarchInfo enforceHook(StorextarchInfo recordInfo) {
		InfoSetter<StorextarchInfo> attrSetter = new StorextarchSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
