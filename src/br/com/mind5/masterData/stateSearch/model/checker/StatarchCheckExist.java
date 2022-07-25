package br.com.mind5.masterData.stateSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.action.StatarchVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StatarchCheckExist extends ModelCheckerTemplateAction<StatarchInfo, StatarchInfo> {
	
	public StatarchCheckExist(ModelCheckerOption option) {
		super(option, StatarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<StatarchInfo> buildActionHook(DeciTreeOption<StatarchInfo> option) {
		ActionStd<StatarchInfo> select = new ActionStdCommom<StatarchInfo>(option, StatarchVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STATE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STATE_SEARCH_NOT_FOUND;
	}
}
