package br.com.mind5.business.ownerSearch.model.action;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnarchMergeToSelect extends ActionStdTemplateV2<OwnarchInfo> {

	public StdOwnarchMergeToSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OwnarchInfo> buildVisitorHook(DeciTreeOption<OwnarchInfo> option) {
		return new VisiOwnarchMergeToSelect(option);
	}
}