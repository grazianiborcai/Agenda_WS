package br.com.mind5.payment.refundOrder.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class StdRefuMergeOrdist extends ActionStdTemplate<RefuInfo> {

	public StdRefuMergeOrdist(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<RefuInfo> buildVisitorHook(DeciTreeOption<RefuInfo> option) {
		return new VisiRefuMergeOrdist(option);
	}
}
