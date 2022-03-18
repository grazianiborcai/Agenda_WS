package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action.StedmoniveVisiMergeSytotauh;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.checker.StedmoniveCheckSytotin;

public final class StedmoniveNodeAuthL2 extends DeciTreeTemplateWrite<StedmoniveInfo> {
	
	public StedmoniveNodeAuthL2(DeciTreeOption<StedmoniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StedmoniveInfo> buildCheckerHook(DeciTreeOption<StedmoniveInfo> option) {
		List<ModelChecker<StedmoniveInfo>> queue = new ArrayList<>();		
		ModelChecker<StedmoniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StedmoniveCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StedmoniveInfo>> buildActionsOnPassedHook(DeciTreeOption<StedmoniveInfo> option) {
		List<ActionStd<StedmoniveInfo>> actions = new ArrayList<>();
		
		ActionStd<StedmoniveInfo> mergeSytotauh = new ActionStdCommom<StedmoniveInfo>(option, StedmoniveVisiMergeSytotauh.class);		
		
		actions.add(mergeSytotauh);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StedmoniveInfo>> buildActionsOnFailedHook(DeciTreeOption<StedmoniveInfo> option) {
		List<ActionStd<StedmoniveInfo>> actions = new ArrayList<>();
		
		ActionStd<StedmoniveInfo> success = new ActionStdSuccessCommom<StedmoniveInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
