package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.info.CustamonInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiMergeCalonthLtm;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiRootSelect;


public final class CustamonRootSelectLtm extends DeciTreeTemplateWrite<CustamonInfo> {
	
	public CustamonRootSelectLtm(DeciTreeOption<CustamonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustamonInfo> buildCheckerHook(DeciTreeOption<CustamonInfo> option) {
		List<ModelChecker<CustamonInfo>> queue = new ArrayList<>();		
		ModelChecker<CustamonInfo> checker;

		checker = new ModelCheckerDummy<CustamonInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustamonInfo>> buildActionsOnPassedHook(DeciTreeOption<CustamonInfo> option) {
		List<ActionStd<CustamonInfo>> actions = new ArrayList<>();

		ActionStd<CustamonInfo> mergeCalonthLtm = new ActionStdCommom<CustamonInfo>(option, CustamonVisiMergeCalonthLtm.class);
		ActionLazy<CustamonInfo> select = new ActionLazyCommom<CustamonInfo>(option, CustamonVisiRootSelect.class);
		
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
