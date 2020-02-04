package br.com.mind5.business.planingData.model.checker;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.decisionTree.RootPlanataSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanataCheckExist extends ModelCheckerTemplateActionV2<PlanataInfo, PlanataInfo> {
	
	public PlanataCheckExist(ModelCheckerOption option) {
		super(option, PlanataInfo.class);
	}
	
	
	
	@Override protected ActionStd<PlanataInfo> buildActionHook(DeciTreeOption<PlanataInfo> option) {
		ActionStd<PlanataInfo> select = new RootPlanataSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PLAN_DATA_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PLAN_DATA_NOT_FOUND;
	}
}
