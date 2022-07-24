package br.com.mind5.masterData.country.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.action.CountryVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryCheckExist extends ModelCheckerTemplateAction<CountryInfo, CountryInfo> {
	
	public CountryCheckExist(ModelCheckerOption option) {
		super(option, CountryInfo.class);
	}
	
	
	
	@Override protected ActionStd<CountryInfo> buildActionHook(DeciTreeOption<CountryInfo> option) {
		ActionStd<CountryInfo> select = new ActionStdCommom<CountryInfo>(option, CountryVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_NOT_FOUND;
	}
}
