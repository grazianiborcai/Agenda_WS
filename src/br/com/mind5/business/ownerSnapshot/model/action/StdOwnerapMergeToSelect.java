package br.com.mind5.business.ownerSnapshot.model.action;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerapMergeToSelect extends ActionStdTemplateV2<OwnerapInfo> {

	public StdOwnerapMergeToSelect(DeciTreeOption<OwnerapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OwnerapInfo> buildVisitorHook(DeciTreeOption<OwnerapInfo> option) {
		return new VisiOwnerapMergeToSelect(option);
	}
}
