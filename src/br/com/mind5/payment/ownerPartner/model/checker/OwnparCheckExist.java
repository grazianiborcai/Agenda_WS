package br.com.mind5.payment.ownerPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.action.OwnparVisiDaoSelect;

public final class OwnparCheckExist extends ModelCheckerTemplateAction<OwnparInfo, OwnparInfo> {
	
	public OwnparCheckExist(ModelCheckerOption option) {
		super(option, OwnparInfo.class);
	}
	

	
	@Override protected ActionStd<OwnparInfo> buildActionHook(DeciTreeOption<OwnparInfo> option) {
		ActionStd<OwnparInfo> select = new ActionStdCommom<OwnparInfo>(option, OwnparVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_OWNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_OWNER_NOT_FOUND;
	}
}
