package br.com.mind5.business.customerList.model.action;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCuslisMergeToSelect extends ActionStdTemplate<CuslisInfo> {

	public StdCuslisMergeToSelect(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CuslisInfo> buildVisitorHook(DeciTreeOption<CuslisInfo> option) {
		return new VisiCuslisMergeToSelect(option);
	}
}
