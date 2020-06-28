package br.com.mind5.business.companyConflict.model.action;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompcoDaoSelect extends ActionStdTemplateV2<CompcoInfo> {

	public StdCompcoDaoSelect(DeciTreeOption<CompcoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CompcoInfo> buildVisitorHook(DeciTreeOption<CompcoInfo> option) {
		return new VisiCompcoDaoSelect(option);
	}
}
