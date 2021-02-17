package br.com.mind5.business.orderHistory.model.action;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdoryMergeOrdistSearch extends ActionStdTemplate<OrdoryInfo> {

	public StdOrdoryMergeOrdistSearch(DeciTreeOption<OrdoryInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdoryInfo> buildVisitorHook(DeciTreeOption<OrdoryInfo> option) {
		return new VisiOrdoryMergeOrdistSearch(option);
	}
}
