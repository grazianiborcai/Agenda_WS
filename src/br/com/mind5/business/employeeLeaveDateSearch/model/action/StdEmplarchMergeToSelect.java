package br.com.mind5.business.employeeLeaveDateSearch.model.action;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplarchMergeToSelect extends ActionStdTemplateV2<EmplarchInfo> {

	public StdEmplarchMergeToSelect(DeciTreeOption<EmplarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmplarchInfo> buildVisitorHook(DeciTreeOption<EmplarchInfo> option) {
		return new VisiEmplarchMergeToSelect(option);
	}
}
