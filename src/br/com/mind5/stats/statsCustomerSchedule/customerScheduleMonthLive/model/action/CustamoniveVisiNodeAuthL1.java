package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.decisionTree.CustamoniveNodeAuthL1;

public final class CustamoniveVisiNodeAuthL1 extends ActionVisitorTemplateAction<CustamoniveInfo, CustamoniveInfo> {

	public CustamoniveVisiNodeAuthL1(DeciTreeOption<CustamoniveInfo> option) {
		super(option, CustamoniveInfo.class, CustamoniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustamoniveInfo>> getTreeClassHook() {
		return CustamoniveNodeAuthL1.class;
	}
	
	
	
	@Override protected List<CustamoniveInfo> toBaseClassHook(List<CustamoniveInfo> baseInfos, List<CustamoniveInfo> results) {
		return results;
	}
}
