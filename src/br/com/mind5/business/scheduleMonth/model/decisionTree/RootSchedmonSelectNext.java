package br.com.mind5.business.scheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.model.action.LazySchedmonRootSelect;
import br.com.mind5.business.scheduleMonth.model.action.StdSchedmonEnforceNext;
import br.com.mind5.business.scheduleMonth.model.checker.SchedmonCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedmonSelectNext extends DeciTreeTemplateWriteV2<SchedmonInfo> {
	
	public RootSchedmonSelectNext(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedmonInfo> buildCheckerHook(DeciTreeOption<SchedmonInfo> option) {
		List<ModelCheckerV1<SchedmonInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedmonInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedmonCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStdV1<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedmonInfo> enforceNext = new StdSchedmonEnforceNext(option);
		ActionLazyV1<SchedmonInfo> select = new LazySchedmonRootSelect(option.conn, option.schemaName);

		enforceNext.addPostAction(select);
		
		actions.add(enforceNext);
		return actions;
	}
}
