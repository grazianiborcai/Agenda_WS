package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineDaoDelete;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceCancelled;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceLChanged;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineInsertSchedovm;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeUsername;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeSnapshot;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineMergeToSelect;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckCancel;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedineCancel extends DeciTreeTemplateWriteV2<SchedineInfo> {
	
	public NodeSchedineCancel(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelCheckerV1<SchedineInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedineCheckCancel(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV1<SchedineInfo>> actions = new ArrayList<>();
		//TODO: send email ?
		ActionStdV1<SchedineInfo> mergeToSelect = new StdSchedineMergeToSelect(option);
		ActionLazyV1<SchedineInfo> enforceLChanged = new LazySchedineEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> mergeUsername = new LazySchedineMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> enforceStatus = new LazySchedineEnforceCancelled(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> nodeSnapshot = new LazySchedineNodeSnapshot(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> insertSchedovm = new LazySchedineInsertSchedovm(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> delete = new LazySchedineDaoDelete(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodeSnapshot);
		nodeSnapshot.addPostAction(insertSchedovm);
		insertSchedovm.addPostAction(delete);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
