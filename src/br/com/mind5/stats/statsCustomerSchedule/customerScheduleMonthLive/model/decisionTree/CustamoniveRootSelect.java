package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.info.CustamoniveInfo;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action.CustamoniveVisiEnforceLChanged;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action.CustamoniveVisiMergeCalonth;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action.CustamoniveVisiMergeState;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.action.CustamoniveVisiMergeToSelect;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker.CustamoniveCheckLangu;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker.CustamoniveCheckOwner;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker.CustamoniveCheckRead;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthLive.model.checker.CustamoniveCheckCus;


public final class CustamoniveRootSelect extends DeciTreeTemplateWrite<CustamoniveInfo> {
	
	public CustamoniveRootSelect(DeciTreeOption<CustamoniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CustamoniveInfo> buildCheckerHook(DeciTreeOption<CustamoniveInfo> option) {
		List<ModelChecker<CustamoniveInfo>> queue = new ArrayList<>();		
		ModelChecker<CustamoniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new CustamoniveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CustamoniveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CustamoniveCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CustamoniveCheckCus(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CustamoniveInfo>> buildActionsOnPassedHook(DeciTreeOption<CustamoniveInfo> option) {
		List<ActionStd<CustamoniveInfo>> actions = new ArrayList<>();

		ActionStd<CustamoniveInfo> select = new ActionStdCommom<CustamoniveInfo>(option, CustamoniveVisiMergeToSelect.class);
		ActionLazy<CustamoniveInfo> enforceLChanged = new ActionLazyCommom<CustamoniveInfo>(option, CustamoniveVisiEnforceLChanged.class);
		ActionLazy<CustamoniveInfo> mergeState = new ActionLazyCommom<CustamoniveInfo>(option, CustamoniveVisiMergeState.class);
		ActionLazy<CustamoniveInfo> mergeCalonth = new ActionLazyCommom<CustamoniveInfo>(option, CustamoniveVisiMergeCalonth.class);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeCalonth);
		
		actions.add(select);
		return actions;
	}
}
