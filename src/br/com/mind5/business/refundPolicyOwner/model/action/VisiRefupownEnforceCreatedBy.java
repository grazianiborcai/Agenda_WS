package br.com.mind5.business.refundPolicyOwner.model.action;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownEnforceCreatedBy extends ActionVisitorTemplateEnforceV2<RefupownInfo> {
	
	public VisiRefupownEnforceCreatedBy(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}

	
	
	@Override protected RefupownInfo enforceHook(RefupownInfo recordInfo) {
		InfoSetter<RefupownInfo> attrSetter = new RefupownSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
