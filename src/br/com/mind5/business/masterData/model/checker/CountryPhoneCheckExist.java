package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.masterData.model.action.StdCountryPhoneSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryPhoneCheckExist extends ModelCheckerTemplateActionV2<CountryPhoneInfo, CountryPhoneInfo> {
	
	public CountryPhoneCheckExist(ModelCheckerOption option) {
		super(option, CountryPhoneInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CountryPhoneInfo> buildActionHook(DeciTreeOption<CountryPhoneInfo> option) {
		ActionStdV1<CountryPhoneInfo> select = new StdCountryPhoneSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_PHONE_NOT_FOUND;
	}
}
