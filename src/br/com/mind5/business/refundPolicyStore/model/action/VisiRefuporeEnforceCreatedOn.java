package br.com.mind5.business.refundPolicyStore.model.action;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporeEnforceCreatedOn extends ActionVisitorTemplateEnforce<RefuporeInfo> {
	
	public VisiRefuporeEnforceCreatedOn(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}

	
	
	@Override protected RefuporeInfo enforceHook(RefuporeInfo recordInfo) {
		InfoSetter<RefuporeInfo> attrSetter = new RefuporeSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
