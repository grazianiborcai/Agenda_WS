package br.com.mind5.business.scheduleMonthData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.action.LazySchedonthatEnforceWeekday;
import br.com.mind5.business.scheduleMonthData.model.action.StdSchedonthatMergeToSelect;
import br.com.mind5.business.scheduleMonthData.model.checker.SchedonthatCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedonthatSelect extends DeciTreeTemplateWriteV2<SchedonthatInfo> {
	
	public RootSchedonthatSelect(DeciTreeOption<SchedonthatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedonthatInfo> buildCheckerHook(DeciTreeOption<SchedonthatInfo> option) {
		List<ModelCheckerV1<SchedonthatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedonthatInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedonthatCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedonthatInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedonthatInfo> option) {
		List<ActionStdV1<SchedonthatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedonthatInfo> mergeToSelect = new StdSchedonthatMergeToSelect(option);
		ActionLazy<SchedonthatInfo> enforceWeekday = new LazySchedonthatEnforceWeekday(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(enforceWeekday);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
