package br.com.mind5.masterData.countryPhone.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.masterData.countryPhone.model.action.StdCountroneDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountroneCheckExist extends ModelCheckerTemplateActionV2<CountroneInfo, CountroneInfo> {
	
	public CountroneCheckExist(ModelCheckerOption option) {
		super(option, CountroneInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<CountroneInfo> buildActionHook(DeciTreeOption<CountroneInfo> option) {
		ActionStdV2<CountroneInfo> select = new StdCountroneDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_PHONE_NOT_FOUND;
	}
}
