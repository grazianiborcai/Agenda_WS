package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.decisionTree.CustamonNodeZerofy;

public final class CustamonVisiNodeZerofy extends ActionVisitorTemplateAction<CustamonInfo, CustamonInfo> {

	public CustamonVisiNodeZerofy(DeciTreeOption<CustamonInfo> option) {
		super(option, CustamonInfo.class, CustamonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustamonInfo>> getTreeClassHook() {
		return CustamonNodeZerofy.class;
	}
	
	
	
	@Override protected List<CustamonInfo> toBaseClassHook(List<CustamonInfo> baseInfos, List<CustamonInfo> results) {
		return results;
	}
}
