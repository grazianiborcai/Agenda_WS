package br.com.mind5.business.owner.model.action;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.info.OwnerSetterCompKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerEnforceCompKey extends ActionVisitorTemplateEnforceV2<OwnerInfo> {
	
	public VisiOwnerEnforceCompKey(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OwnerInfo enforceHook(OwnerInfo recordInfo) {
		InfoSetter<OwnerInfo> attrSetter = new OwnerSetterCompKey();
		return attrSetter.setAttr(recordInfo);
	}
}
