package br.com.mind5.masterData.country.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.action.StdCountryDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryCheckExist extends ModelCheckerTemplateActionV2<CountryInfo, CountryInfo> {
	
	public CountryCheckExist(ModelCheckerOption option) {
		super(option, CountryInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<CountryInfo> buildActionHook(DeciTreeOption<CountryInfo> option) {
		ActionStdV2<CountryInfo> select = new StdCountryDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_NOT_FOUND;
	}
}
