package br.com.mind5.business.refundPolicyOwner.model.action;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefupownMergeUsername extends ActionStdTemplateV2<RefupownInfo> {

	public StdRefupownMergeUsername(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefupownInfo> buildVisitorHook(DeciTreeOption<RefupownInfo> option) {
		return new VisiRefupownMergeUsername(option);
	}
}
