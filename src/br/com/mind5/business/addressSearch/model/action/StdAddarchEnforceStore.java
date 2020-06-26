package br.com.mind5.business.addressSearch.model.action;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddarchEnforceStore extends ActionStdTemplateV2<AddarchInfo> {

	public StdAddarchEnforceStore(DeciTreeOption<AddarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<AddarchInfo> buildVisitorHook(DeciTreeOption<AddarchInfo> option) {
		return new VisiAddarchEnforceStore(option);
	}
}
