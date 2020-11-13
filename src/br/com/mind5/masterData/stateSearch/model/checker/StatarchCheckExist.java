package br.com.mind5.masterData.stateSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.action.StdStatarchDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StatarchCheckExist extends ModelCheckerTemplateActionV2<StatarchInfo, StatarchInfo> {
	
	public StatarchCheckExist(ModelCheckerOption option) {
		super(option, StatarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<StatarchInfo> buildActionHook(DeciTreeOption<StatarchInfo> option) {
		ActionStdV2<StatarchInfo> select = new StdStatarchDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STATE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STATE_SEARCH_NOT_FOUND;
	}
}
