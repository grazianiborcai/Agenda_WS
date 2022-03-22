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
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiEnforceAddressDefault;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiEnforceZerofy;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiMergeAddress;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonth.model.action.CustamonVisiMergeCuslis;


public final class CustamonNodeZerofy extends DeciTreeTemplateWrite<CustamonInfo> {
	
	public CustamonNodeZerofy(DeciTreeOption<CustamonInfo> option) {
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

		ActionStd<CustamonInfo> zerofy = new ActionStdCommom<CustamonInfo>(option, CustamonVisiEnforceZerofy.class);
		ActionLazy<CustamonInfo> mergeCuslis = new ActionLazyCommom<CustamonInfo>(option, CustamonVisiMergeCuslis.class);
		ActionLazy<CustamonInfo> enforceAddressDefault = new ActionLazyCommom<CustamonInfo>(option, CustamonVisiEnforceAddressDefault.class);
		ActionLazy<CustamonInfo> mergeAddress = new ActionLazyCommom<CustamonInfo>(option, CustamonVisiMergeAddress.class);
		
		zerofy.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(enforceAddressDefault);
		enforceAddressDefault.addPostAction(mergeAddress);
		
		actions.add(zerofy);
		return actions;
	}
}
