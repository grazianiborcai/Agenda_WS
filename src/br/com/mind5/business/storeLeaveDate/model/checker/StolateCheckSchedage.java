package br.com.mind5.business.storeLeaveDate.model.checker;

import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageCopier;
import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.business.scheduleRange.model.decisionTree.RootSchedageSelect;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateCheckSchedage extends ModelCheckerTemplateActionV2<StolateInfo, SchedageInfo> {
	
	public StolateCheckSchedage(ModelCheckerOption option) {
		super(option, SchedageInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedageInfo> buildActionHook(DeciTreeOption<SchedageInfo> option) {
		ActionStd<SchedageInfo> select = new RootSchedageSelect(option).toAction();
		return select;
	}
	
	
	
	protected List<SchedageInfo> toActionClassHook(List<StolateInfo> recordInfos) {
		return SchedageCopier.copyFromStolate(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_SCHEDULE_CONFLICT;
	}	
}
