package br.com.mind5.business.employeePositionSearch.model.action;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposarchDaoSelect extends ActionStdTemplateV2<EmposarchInfo> {

	public StdEmposarchDaoSelect(DeciTreeOption<EmposarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmposarchInfo> buildVisitorHook(DeciTreeOption<EmposarchInfo> option) {
		return new VisiEmposarchDaoSelect(option);
	}
}
