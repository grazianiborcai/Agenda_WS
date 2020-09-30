package br.com.mind5.business.storeSnapshot.model.action;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapSetterStorextsnapKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorapEnforceStorextsnapKey extends ActionVisitorTemplateEnforceV2<StorapInfo> {
	
	public VisiStorapEnforceStorextsnapKey(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected StorapInfo enforceHook(StorapInfo recordInfo) {
		InfoSetter<StorapInfo> attrSetter = new StorapSetterStorextsnapKey();
		return attrSetter.setAttr(recordInfo);
	}
}
