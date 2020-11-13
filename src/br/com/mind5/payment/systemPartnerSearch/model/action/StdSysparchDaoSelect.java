package br.com.mind5.payment.systemPartnerSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

public final class StdSysparchDaoSelect extends ActionStdTemplate<SysparchInfo> {

	public StdSysparchDaoSelect(DeciTreeOption<SysparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SysparchInfo> buildVisitorHook(DeciTreeOption<SysparchInfo> option) {
		return new VisiSysparchDaoSelect(option);
	}
}
