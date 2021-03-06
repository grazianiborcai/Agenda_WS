package br.com.mind5.business.refundPolicyStoreSearch.model.action;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefupowarchMergeToSelect extends ActionStdTemplate<RefuporarchInfo> {
	
	public StdRefupowarchMergeToSelect(DeciTreeOption<RefuporarchInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitor<RefuporarchInfo> buildVisitorHook(DeciTreeOption<RefuporarchInfo> option) {
		return new VisiRefuporarchMergeToSelect(option);
	}
}
