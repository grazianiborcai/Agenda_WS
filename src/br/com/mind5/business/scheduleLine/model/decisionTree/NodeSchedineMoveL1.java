package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineBookiceValidate;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineRootInsertForce;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineEnforceRef;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedineMoveL1 extends DeciTreeTemplateWriteV2<SchedineInfo> {
	
	public NodeSchedineMoveL1(DeciTreeOption<SchedineInfo> option) {
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
		
		ActionStdV1<SchedineInfo> enforceRef = new StdSchedineEnforceRef(option);
		ActionLazyV1<SchedineInfo> bookiceValidate = new LazySchedineBookiceValidate(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> insert = new LazySchedineRootInsertForce(option.conn, option.schemaName);
		
		enforceRef.addPostAction(bookiceValidate);
		bookiceValidate.addPostAction(insert);
		
		actions.add(enforceRef);
		return actions;
	}
}
