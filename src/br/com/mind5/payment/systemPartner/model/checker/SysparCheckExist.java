package br.com.mind5.payment.systemPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.action.StdSysparDaoSelect;

public final class SysparCheckExist extends ModelCheckerTemplateActionV2<SysparInfo, SysparInfo> {
	
	public SysparCheckExist(ModelCheckerOption option) {
		super(option, SysparInfo.class);
	}
	

	
	@Override protected ActionStdV1<SysparInfo> buildActionHook(DeciTreeOption<SysparInfo> option) {
		ActionStdV1<SysparInfo> select = new StdSysparDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_PAY_PARTNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_PAY_PARTNER_NOT_FOUND;
	}
}
