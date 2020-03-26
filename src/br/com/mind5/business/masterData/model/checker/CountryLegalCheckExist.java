package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.business.masterData.model.action.StdCountryLegalSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryLegalCheckExist extends ModelCheckerTemplateAction<CountryLegalInfo, CountryLegalInfo> {
	
	public CountryLegalCheckExist(ModelCheckerOption option) {
		super(option, CountryLegalInfo.class);
	}
	
	
	
	@Override protected ActionStd<CountryLegalInfo> buildActionHook(DeciTreeOption<CountryLegalInfo> option) {
		ActionStd<CountryLegalInfo> select = new StdCountryLegalSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_LEGAL_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_LEGAL_NOT_FOUND;
	}
}
