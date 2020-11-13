package br.com.mind5.payment.systemPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class StdSysparDaoSelect extends ActionStdTemplateV2<SysparInfo> {

	public StdSysparDaoSelect(DeciTreeOption<SysparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SysparInfo> buildVisitorHook(DeciTreeOption<SysparInfo> option) {
		return new VisiSysparDaoSelect(option);
	}
}
