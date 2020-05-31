package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceLChanged;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceStatus;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeCuslis;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeUsername;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeOrderL1;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeCalate;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineMergeToUpdate_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedineUpdate_ extends DeciTreeTemplateWriteV2<SchedineInfo> {
	
	public NodeSchedineUpdate_(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelCheckerV1<SchedineInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedineInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV1<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedineInfo> mergeToUpdate = new StdSchedineMergeToUpdate_(option);
		ActionLazyV1<SchedineInfo> nodeOrder = new LazySchedineNodeOrderL1(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> enforceLChanged = new LazySchedineEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> mergeCuslis = new LazySchedineMergeCuslis(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> mergeUsername = new LazySchedineMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> mergeCalate = new LazySchedineMergeCalate(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> enforceStatus = new LazySchedineEnforceStatus(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(nodeOrder);
		nodeOrder.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeCuslis);		
		mergeCuslis.addPostAction(mergeUsername);
		mergeUsername.addPostAction(mergeCalate);
		mergeCalate.addPostAction(enforceStatus);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
