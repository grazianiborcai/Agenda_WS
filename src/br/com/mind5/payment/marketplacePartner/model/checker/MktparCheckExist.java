package br.com.mind5.payment.marketplacePartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.marketplacePartner.model.action.MktparVisiDaoSelect;

public final class MktparCheckExist extends ModelCheckerTemplateAction<MktparInfo, MktparInfo> {
	
	public MktparCheckExist(ModelCheckerOption option) {
		super(option, MktparInfo.class);
	}
	

	
	@Override protected ActionStd<MktparInfo> buildActionHook(DeciTreeOption<MktparInfo> option) {
		ActionStd<MktparInfo> select = new ActionStdCommom<MktparInfo>(option, MktparVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_PAY_PARTNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_PAY_PARTNER_NOT_FOUND;
	}
}
