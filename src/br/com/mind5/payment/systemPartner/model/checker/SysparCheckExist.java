package br.com.mind5.payment.systemPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.action.SysparVisiDaoSelect;

public final class SysparCheckExist extends ModelCheckerTemplateAction<SysparInfo, SysparInfo> {
	
	public SysparCheckExist(ModelCheckerOption option) {
		super(option, SysparInfo.class);
	}
	

	
	@Override protected ActionStd<SysparInfo> buildActionHook(DeciTreeOption<SysparInfo> option) {
		ActionStd<SysparInfo> select = new ActionStdCommom<SysparInfo>(option, SysparVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_PAY_PARTNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_PAY_PARTNER_NOT_FOUND;
	}
}
