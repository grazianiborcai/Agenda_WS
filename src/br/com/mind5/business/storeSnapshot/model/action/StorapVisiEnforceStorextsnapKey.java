package br.com.mind5.business.storeSnapshot.model.action;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapSetterStorextsnapKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorapVisiEnforceStorextsnapKey extends ActionVisitorTemplateEnforce<StorapInfo> {
	
	public StorapVisiEnforceStorextsnapKey(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StorapInfo enforceHook(StorapInfo recordInfo) {
		InfoSetter<StorapInfo> attrSetter = new StorapSetterStorextsnapKey();
		return attrSetter.setAttr(recordInfo);
	}
}
