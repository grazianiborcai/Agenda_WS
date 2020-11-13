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
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedineRefreshL1 extends DeciTreeTemplateWriteV2<SchedineInfo> {
	
	public NodeSchedineRefreshL1(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelCheckerV1<SchedineInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckSchedarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV2<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStdV2<SchedineInfo> mergeSchedarch = new StdSchedineMergeSchedarch(option);
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
	
	
	
	@Override protected List<ActionStdV2<SchedineInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV2<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStdV2<SchedineInfo> success = new StdSchedineSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
