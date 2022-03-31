package br.com.mind5.business.scheduleReserve.model.checker;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.model.decisionTree.SchederveRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchederveCheckExist extends ModelCheckerTemplateAction<SchederveInfo, SchederveInfo> {
	
	public SchederveCheckExist(ModelCheckerOption option) {
		super(option, SchederveInfo.class);
	}
	

	
	@Override protected ActionStd<SchederveInfo> buildActionHook(DeciTreeOption<SchederveInfo> option) {
		ActionStd<SchederveInfo> select = new SchederveRootSelect(option).toAction();
		return select;
	}
	
	
		
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_RESERVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_RESERVE_NOT_FOUND;
	}
}
