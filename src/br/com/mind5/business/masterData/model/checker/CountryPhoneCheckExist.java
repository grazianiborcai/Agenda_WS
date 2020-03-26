package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.masterData.model.action.StdCountryPhoneSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryPhoneCheckExist extends ModelCheckerTemplateAction<CountryPhoneInfo, CountryPhoneInfo> {
	
	public CountryPhoneCheckExist(ModelCheckerOption option) {
		super(option, CountryPhoneInfo.class);
	}
	
	
	
	@Override protected ActionStd<CountryPhoneInfo> buildActionHook(DeciTreeOption<CountryPhoneInfo> option) {
		ActionStd<CountryPhoneInfo> select = new StdCountryPhoneSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_PHONE_NOT_FOUND;
	}
}
