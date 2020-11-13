package br.com.mind5.business.orderSearch.model.action;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdarchMergeToSelect extends ActionStdTemplate<OrdarchInfo> {

	public StdOrdarchMergeToSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdarchInfo> buildVisitorHook(DeciTreeOption<OrdarchInfo> option) {
		return new VisiOrdarchMergeToSelect(option);
	}
}
