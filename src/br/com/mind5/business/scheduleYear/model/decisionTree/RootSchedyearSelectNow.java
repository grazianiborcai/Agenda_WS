package br.com.mind5.business.scheduleYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.action.LazySchedyearRootSelect;
import br.com.mind5.business.scheduleYear.model.action.StdSchedyearEnforceNow;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedyearSelectNow extends DeciTreeTemplateWriteV2<SchedyearInfo> {
	
	public RootSchedyearSelectNow(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedyearInfo> buildCheckerHook(DeciTreeOption<SchedyearInfo> option) {
		List<ModelCheckerV1<SchedyearInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedyearInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedyearInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStdV1<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedyearInfo> enforceNow = new StdSchedyearEnforceNow(option);
		ActionLazyV1<SchedyearInfo> select = new LazySchedyearRootSelect(option.conn, option.schemaName);

		enforceNow.addPostAction(select);
		
		actions.add(enforceNow);
		return actions;
	}
}
