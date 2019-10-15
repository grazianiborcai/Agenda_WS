package br.com.gda.business.storeLeaveDate.model.checker;

import java.util.List;

import br.com.gda.business.scheduleRange.info.SchedageCopier;
import br.com.gda.business.scheduleRange.info.SchedageInfo;
import br.com.gda.business.scheduleRange.model.decisionTree.RootSchedageSelect;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
