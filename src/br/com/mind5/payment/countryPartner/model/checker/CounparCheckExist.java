package br.com.mind5.payment.countryPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.action.CounparVisiDaoSelect;

public final class CounparCheckExist extends ModelCheckerTemplateAction<CounparInfo, CounparInfo> {
	
	public CounparCheckExist(ModelCheckerOption option) {
		super(option, CounparInfo.class);
	}
	

	
	@Override protected ActionStd<CounparInfo> buildActionHook(DeciTreeOption<CounparInfo> option) {
		ActionStd<CounparInfo> select = new ActionStdCommom<CounparInfo>(option, CounparVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_COUNTRY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_COUNTRY_NOT_FOUND;
	}
}
