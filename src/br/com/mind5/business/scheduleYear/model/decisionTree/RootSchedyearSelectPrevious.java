package br.com.mind5.business.scheduleYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.action.LazySchedyearRootSelect;
import br.com.mind5.business.scheduleYear.model.action.StdSchedyearEnforcePrevious;
import br.com.mind5.business.scheduleYear.model.checker.SchedyearCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedyearSelectPrevious extends DeciTreeTemplateWriteV2<SchedyearInfo> {
	
	public RootSchedyearSelectPrevious(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedyearInfo> buildCheckerHook(DeciTreeOption<SchedyearInfo> option) {
		List<ModelCheckerV1<SchedyearInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedyearInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedyearCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<SchedyearInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStdV2<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStdV2<SchedyearInfo> enforcePrevious = new StdSchedyearEnforcePrevious(option);
		ActionLazy<SchedyearInfo> select = new LazySchedyearRootSelect(option.conn, option.schemaName);

		enforcePrevious.addPostAction(select);
		
		actions.add(enforcePrevious);
		return actions;
	}
}
