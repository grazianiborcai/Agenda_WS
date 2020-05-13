package br.com.mind5.business.scheduleReserve.model.checker;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.model.decisionTree.RootSchederveSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchederveCheckExist extends ModelCheckerTemplateActionV2<SchederveInfo, SchederveInfo> {
	
	public SchederveCheckExist(ModelCheckerOption option) {
		super(option, SchederveInfo.class);
	}
	

	
	@Override protected ActionStdV1<SchederveInfo> buildActionHook(DeciTreeOption<SchederveInfo> option) {
		ActionStdV1<SchederveInfo> select = new RootSchederveSelect(option).toAction();
		return select;
	}
	
	
		
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_RESERVE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_RESERVE_NOT_FOUND;
	}
}
