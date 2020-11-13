package br.com.mind5.business.scheduleMonthData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.action.LazySchedonthatEnforceWeekday;
import br.com.mind5.business.scheduleMonthData.model.action.StdSchedonthatMergeToSelect;
import br.com.mind5.business.scheduleMonthData.model.checker.SchedonthatCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedonthatSelect extends DeciTreeTemplateWrite<SchedonthatInfo> {
	
	public RootSchedonthatSelect(DeciTreeOption<SchedonthatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedonthatInfo> buildCheckerHook(DeciTreeOption<SchedonthatInfo> option) {
		List<ModelChecker<SchedonthatInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedonthatInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedonthatCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedonthatInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedonthatInfo> option) {
		List<ActionStd<SchedonthatInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedonthatInfo> mergeToSelect = new StdSchedonthatMergeToSelect(option);
		ActionLazy<SchedonthatInfo> enforceWeekday = new LazySchedonthatEnforceWeekday(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(enforceWeekday);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
