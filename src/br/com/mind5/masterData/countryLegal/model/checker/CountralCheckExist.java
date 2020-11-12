package br.com.mind5.masterData.countryLegal.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.action.StdCountralDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountralCheckExist extends ModelCheckerTemplateActionV2<CountralInfo, CountralInfo> {
	
	public CountralCheckExist(ModelCheckerOption option) {
		super(option, CountralInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CountralInfo> buildActionHook(DeciTreeOption<CountralInfo> option) {
		ActionStdV1<CountralInfo> select = new StdCountralDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_LEGAL_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_LEGAL_NOT_FOUND;
	}
}
