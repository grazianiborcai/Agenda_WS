package br.com.mind5.business.refundPolicyOwner.model.action;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefupownMergeToSelect extends ActionStdTemplate<RefupownInfo> {
	
	public StdRefupownMergeToSelect(DeciTreeOption<RefupownInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitor<RefupownInfo> buildVisitorHook(DeciTreeOption<RefupownInfo> option) {
		return new VisiRefupownMergeToSelect(option);
	}
}
