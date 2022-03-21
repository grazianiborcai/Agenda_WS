package br.com.mind5.payment.storePartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.StoparVisiDaoSelect;
import br.com.mind5.payment.storePartner.model.action.StoparVisiEnforceDel;

public final class StoparCheckSoftDelete extends ModelCheckerTemplateAction<StoparInfo, StoparInfo> {
	
	public StoparCheckSoftDelete(ModelCheckerOption option) {
		super(option, StoparInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoparInfo> buildActionHook(DeciTreeOption<StoparInfo> option) {
		ActionStd<StoparInfo> enforceDel = new ActionStdCommom<StoparInfo>(option, StoparVisiEnforceDel.class);
		ActionLazy<StoparInfo> select = new ActionLazyCommom<StoparInfo>(option, StoparVisiDaoSelect.class);
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_STORE_FLAGGED_AS_DELETED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_NOT_FOUND;
	}
}
