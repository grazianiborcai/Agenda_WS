package br.com.mind5.payment.systemPartnerSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

public final class StdSysparchDaoSelect extends ActionStdTemplateV2<SysparchInfo> {

	public StdSysparchDaoSelect(DeciTreeOption<SysparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SysparchInfo> buildVisitorHook(DeciTreeOption<SysparchInfo> option) {
		return new VisiSysparchDaoSelect(option);
	}
}
