package br.com.mind5.business.employeeMaterialSearch.model.action;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmarchDaoSelect extends ActionStdTemplate<EmpmarchInfo> {

	public StdEmpmarchDaoSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmpmarchInfo> buildVisitorHook(DeciTreeOption<EmpmarchInfo> option) {
		return new VisiEmpmarchDaoSelect(option);
	}
}
