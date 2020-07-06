package br.com.mind5.business.customerSearch.model.action;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusarchEnforceEntityCateg extends ActionStdTemplateV2<CusarchInfo> {

	public StdCusarchEnforceEntityCateg(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CusarchInfo> buildVisitorHook(DeciTreeOption<CusarchInfo> option) {
		return new VisiCusarchEnforceEntityCateg(option);
	}
}
