package br.com.mind5.business.refundPolicy.model.action;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefupolMergeOrderem extends ActionStdTemplate<RefupolInfo> {

	public StdRefupolMergeOrderem(DeciTreeOption<RefupolInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<RefupolInfo> buildVisitorHook(DeciTreeOption<RefupolInfo> option) {
		return new VisiRefupolMergeOrderem(option);
	}
}
