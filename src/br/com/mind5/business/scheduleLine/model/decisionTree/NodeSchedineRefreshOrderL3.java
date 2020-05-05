package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceStatus;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeOrdist;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeSchedarch;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeToSelect;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeRefreshOrderL4;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineEnforceOrderKey;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineSuccess;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckSchedarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedineRefreshOrderL3 extends DeciTreeTemplateWriteV2<SchedineInfo> {
	
	public NodeSchedineRefreshOrderL3(DeciTreeOption<SchedineInfo> option) {
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
	
	
	
	@Override protected List<ActionStdV1<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV1<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedineInfo> enforceOrderKey = new StdSchedineEnforceOrderKey(option);
		ActionLazyV1<SchedineInfo> mergeSchedarch = new LazySchedineMergeSchedarch(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> mergeToSelect = new LazySchedineMergeToSelect(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> mergeOrdist = new LazySchedineMergeOrdist(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> enforceStatus = new LazySchedineEnforceStatus(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> nodeL4 = new LazySchedineNodeRefreshOrderL4(option.conn, option.schemaName);
		
		enforceOrderKey.addPostAction(mergeSchedarch);
		mergeSchedarch.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(mergeOrdist);
		mergeOrdist.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodeL4);
		
		actions.add(enforceOrderKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<SchedineInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV1<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedineInfo> success = new StdSchedineSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
