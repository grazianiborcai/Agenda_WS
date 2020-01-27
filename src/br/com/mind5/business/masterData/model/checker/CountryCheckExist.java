package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.model.action.StdCountrySelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryCheckExist extends ModelCheckerTemplateActionV2<CountryInfo, CountryInfo> {
	
	public CountryCheckExist(ModelCheckerOption option) {
		super(option, CountryInfo.class);
	}
	
	
	
	@Override protected ActionStd<CountryInfo> buildActionHook(DeciTreeOption<CountryInfo> option) {
		ActionStd<CountryInfo> select = new StdCountrySelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_NOT_FOUND;
	}
}
