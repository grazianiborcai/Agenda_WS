package br.com.mind5.payment.countryPartnerSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;
import br.com.mind5.payment.countryPartnerSearch.model.decisionTree.RootCounparchSelect;

public final class CounparchCheckExist extends ModelCheckerTemplateAction<CounparchInfo, CounparchInfo> {
	
	public CounparchCheckExist(ModelCheckerOption option) {
		super(option, CounparchInfo.class);
	}
	

	
	@Override protected ActionStd<CounparchInfo> buildActionHook(DeciTreeOption<CounparchInfo> option) {
		ActionStd<CounparchInfo> select = new RootCounparchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAYPAR_COUNTRY_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYPAR_COUNTRY_SEARCH_NOT_FOUND;
	}
}
