package br.com.mind5.business.addressDefault.model.action;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddaultDaoSelect extends ActionStdTemplateV2<AddaultInfo> {

	public StdAddaultDaoSelect(DeciTreeOption<AddaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<AddaultInfo> buildVisitorHook(DeciTreeOption<AddaultInfo> option) {
		return new VisiAddaultDaoSelect(option);
	}
}
