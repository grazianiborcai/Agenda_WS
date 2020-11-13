package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceStatus;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeOrdemist;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeToSelect;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeRefreshL2;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineMergeSchedarch;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineSuccess;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckSchedarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSchedineRefreshL1 extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public NodeSchedineRefreshL1(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckSchedarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> mergeSchedarch = new StdSchedineMergeSchedarch(option);
		ActionLazy<SchedineInfo> mergeToSelect = new LazySchedineMergeToSelect(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeOrdemist = new LazySchedineMergeOrdemist(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceStatus = new LazySchedineEnforceStatus(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeL2 = new LazySchedineNodeRefreshL2(option.conn, option.schemaName);
		
		mergeSchedarch.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(mergeOrdemist);
		mergeOrdemist.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodeL2);
		
		actions.add(mergeSchedarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> success = new StdSchedineSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
