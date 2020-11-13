package br.com.mind5.business.customerSearch.model.action;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdCusarchMergeToSelect extends ActionStdTemplate<CusarchInfo> {

	public StdCusarchMergeToSelect(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CusarchInfo> buildVisitorHook(DeciTreeOption<CusarchInfo> option) {
		return new VisiCusarchMergeToSelect(option);
	}
}
