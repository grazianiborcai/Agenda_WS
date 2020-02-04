package br.com.mind5.business.planingDataSearch.model.checker;

import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.business.planingDataSearch.model.decisionTree.RootPlanarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanarchCheckExist extends ModelCheckerTemplateActionV2<PlanarchInfo, PlanarchInfo> {
	
	public PlanarchCheckExist(ModelCheckerOption option) {
		super(option, PlanarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<PlanarchInfo> buildActionHook(DeciTreeOption<PlanarchInfo> option) {
		ActionStd<PlanarchInfo> select = new RootPlanarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PLAN_DATA_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PLAN_DATA_SEARCH_NOT_FOUND;
	}
}
