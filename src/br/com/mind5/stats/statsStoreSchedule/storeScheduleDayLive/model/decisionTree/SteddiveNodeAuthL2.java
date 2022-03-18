package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.decisionTree;

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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action.SteddiveVisiMergeSytotauh;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.checker.SteddiveCheckSytotin;

public final class SteddiveNodeAuthL2 extends DeciTreeTemplateWrite<SteddiveInfo> {
	
	public SteddiveNodeAuthL2(DeciTreeOption<SteddiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SteddiveInfo> buildCheckerHook(DeciTreeOption<SteddiveInfo> option) {
		List<ModelChecker<SteddiveInfo>> queue = new ArrayList<>();		
		ModelChecker<SteddiveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SteddiveCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SteddiveInfo>> buildActionsOnPassedHook(DeciTreeOption<SteddiveInfo> option) {
		List<ActionStd<SteddiveInfo>> actions = new ArrayList<>();
		
		ActionStd<SteddiveInfo> mergeSytotauh = new ActionStdCommom<SteddiveInfo>(option, SteddiveVisiMergeSytotauh.class);		
		
		actions.add(mergeSytotauh);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SteddiveInfo>> buildActionsOnFailedHook(DeciTreeOption<SteddiveInfo> option) {
		List<ActionStd<SteddiveInfo>> actions = new ArrayList<>();
		
		ActionStd<SteddiveInfo> success = new ActionStdSuccessCommom<SteddiveInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
