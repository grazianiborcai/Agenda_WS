package br.com.mind5.business.refundPolicyOwner.model.action;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownEnforceCreatedOn extends ActionVisitorTemplateEnforce<RefupownInfo> {
	
	public VisiRefupownEnforceCreatedOn(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}

	
	
	@Override protected RefupownInfo enforceHook(RefupownInfo recordInfo) {
		InfoSetter<RefupownInfo> attrSetter = new RefupownSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
