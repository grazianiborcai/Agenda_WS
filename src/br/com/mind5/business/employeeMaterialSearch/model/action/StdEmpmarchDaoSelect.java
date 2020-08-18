package br.com.mind5.business.employeeMaterialSearch.model.action;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmarchDaoSelect extends ActionStdTemplateV2<EmpmarchInfo> {

	public StdEmpmarchDaoSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmpmarchInfo> buildVisitorHook(DeciTreeOption<EmpmarchInfo> option) {
		return new VisiEmpmarchDaoSelect(option);
	}
}
