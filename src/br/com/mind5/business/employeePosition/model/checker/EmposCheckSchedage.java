package br.com.mind5.business.employeePosition.model.checker;

import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.scheduleRange.info.SchedageCopier;
import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.scheduleRange.model.decisionTree.RootSchedageSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckSchedage extends ModelCheckerTemplateActionV2<EmposInfo, SchedageInfo> {
	
	public EmposCheckSchedage(ModelCheckerOption option) {
		super(option, SchedageInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SchedageInfo> buildActionHook(DeciTreeOption<SchedageInfo> option) {
		ActionStdV1<SchedageInfo> select = new RootSchedageSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<SchedageInfo> toActionClassHook(List<EmposInfo> recordInfos) {
		return SchedageCopier.copyFromEmpos(recordInfos);	
	}
	
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMPOS_HAS_SCHEDULE;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_NO_SCHEDULE_FOUND;
	}
}
