package br.com.mind5.business.refundPolicyStore.model.action;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporeEnforceCreatedBy extends ActionVisitorTemplateEnforceV2<RefuporeInfo> {
	
	public VisiRefuporeEnforceCreatedBy(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}

	
	
	@Override protected RefuporeInfo enforceHook(RefuporeInfo recordInfo) {
		InfoSetter<RefuporeInfo> attrSetter = new RefuporeSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
