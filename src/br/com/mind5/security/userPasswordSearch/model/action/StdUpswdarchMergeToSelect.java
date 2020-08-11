package br.com.mind5.security.userPasswordSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

public final class StdUpswdarchMergeToSelect extends ActionStdTemplateV2<UpswdarchInfo> {

	public StdUpswdarchMergeToSelect(DeciTreeOption<UpswdarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<UpswdarchInfo> buildVisitorHook(DeciTreeOption<UpswdarchInfo> option) {
		return new VisiUpswdarchMergeToSelect(option);
	}
}
