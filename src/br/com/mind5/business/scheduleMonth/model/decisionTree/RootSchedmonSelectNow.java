package br.com.mind5.business.scheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.model.action.LazySchedmonRootSelect;
import br.com.mind5.business.scheduleMonth.model.action.StdSchedmonEnforceNow;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedmonSelectNow extends DeciTreeTemplateWriteV2<SchedmonInfo> {
	
	public RootSchedmonSelectNow(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedmonInfo> buildCheckerHook(DeciTreeOption<SchedmonInfo> option) {
		List<ModelCheckerV1<SchedmonInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedmonInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<SchedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStdV2<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStdV2<SchedmonInfo> enforceNow = new StdSchedmonEnforceNow(option);
		ActionLazy<SchedmonInfo> select = new LazySchedmonRootSelect(option.conn, option.schemaName);

		enforceNow.addPostAction(select);
		
		actions.add(enforceNow);
		return actions;
	}
}
