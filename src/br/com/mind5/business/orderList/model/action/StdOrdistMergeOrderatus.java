package br.com.mind5.business.orderList.model.action;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdistMergeOrderatus extends ActionStdTemplate<OrdistInfo> {

	public StdOrdistMergeOrderatus(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdistInfo> buildVisitorHook(DeciTreeOption<OrdistInfo> option) {
		return new VisiOrdistMergeOrderatus(option);
	}
}
