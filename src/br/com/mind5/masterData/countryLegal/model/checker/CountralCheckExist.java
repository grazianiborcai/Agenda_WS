package br.com.mind5.masterData.countryLegal.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.action.CountralVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountralCheckExist extends ModelCheckerTemplateAction<CountralInfo, CountralInfo> {
	
	public CountralCheckExist(ModelCheckerOption option) {
		super(option, CountralInfo.class);
	}
	
	
	
	@Override protected ActionStd<CountralInfo> buildActionHook(DeciTreeOption<CountralInfo> option) {
		ActionStd<CountralInfo> select = new ActionStdCommom<CountralInfo>(option, CountralVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.COUNTRY_LEGAL_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COUNTRY_LEGAL_NOT_FOUND;
	}
}
