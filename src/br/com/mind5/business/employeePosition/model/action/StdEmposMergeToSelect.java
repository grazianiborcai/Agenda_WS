package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposMergeToSelect extends ActionStdTemplateV2<EmposInfo> {

	public StdEmposMergeToSelect(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmposInfo> buildVisitorHook(DeciTreeOption<EmposInfo> option) {
		return new VisiEmposMergeToSelect(option);
	}
}
