package br.com.mind5.payment.systemPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class StdSysparDaoSelect extends ActionStdTemplate<SysparInfo> {

	public StdSysparDaoSelect(DeciTreeOption<SysparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SysparInfo> buildVisitorHook(DeciTreeOption<SysparInfo> option) {
		return new VisiSysparDaoSelect(option);
	}
}
