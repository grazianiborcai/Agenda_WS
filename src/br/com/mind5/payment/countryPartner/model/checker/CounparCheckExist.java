package br.com.mind5.payment.countryPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;
import br.com.mind5.payment.countryPartner.model.action.StdCounparSelect;

public final class CounparCheckExist extends ModelCheckerTemplateAction<CounparInfo, CounparInfo> {
	
	public CounparCheckExist(ModelCheckerOption option) {
		super(option, CounparInfo.class);
	}
	

	
	@Override protected ActionStdV1<CounparInfo> buildActionHook(DeciTreeOption<CounparInfo> option) {
		ActionStdV1<CounparInfo> select = new StdCounparSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_COUNTRY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_COUNTRY_NOT_FOUND;
	}
}
