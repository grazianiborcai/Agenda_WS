package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.business.masterData.model.action.StdCountryLegalSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryLegalCheckExist extends ModelCheckerTemplateActionV2<CountryLegalInfo, CountryLegalInfo> {
	
	public CountryLegalCheckExist(ModelCheckerOption option) {
		super(option, CountryLegalInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CountryLegalInfo> buildActionHook(DeciTreeOption<CountryLegalInfo> option) {
		ActionStdV1<CountryLegalInfo> select = new StdCountryLegalSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_LEGAL_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_LEGAL_NOT_FOUND;
	}
}
