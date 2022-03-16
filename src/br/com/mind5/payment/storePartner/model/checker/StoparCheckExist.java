package br.com.mind5.payment.storePartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.StoparVisiDaoSelect;

public final class StoparCheckExist extends ModelCheckerTemplateAction<StoparInfo, StoparInfo> {
	
	public StoparCheckExist(ModelCheckerOption option) {
		super(option, StoparInfo.class);
	}
	

	
	@Override protected ActionStd<StoparInfo> buildActionHook(DeciTreeOption<StoparInfo> option) {
		ActionStd<StoparInfo> select = new ActionStdCommom<StoparInfo>(option, StoparVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_STORE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_NOT_FOUND;
	}
}
