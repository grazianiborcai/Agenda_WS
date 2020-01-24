package br.com.mind5.business.scheduleMonthData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.action.LazySchedonthatEnforceWeekday;
import br.com.mind5.business.scheduleMonthData.model.action.LazySchedonthatMergeMonth;
import br.com.mind5.business.scheduleMonthData.model.action.LazySchedonthatMergeWeekday;
import br.com.mind5.business.scheduleMonthData.model.action.StdSchedonthatMergeToSelect;
import br.com.mind5.business.scheduleMonthData.model.checker.SchedonthatCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedonthatSelect extends DeciTreeWriteTemplate<SchedonthatInfo> {
	
	public RootSchedonthatSelect(DeciTreeOption<SchedonthatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedonthatInfo> buildDecisionCheckerHook(DeciTreeOption<SchedonthatInfo> option) {
		List<ModelChecker<SchedonthatInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedonthatInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedonthatCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedonthatInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedonthatInfo> option) {
		List<ActionStd<SchedonthatInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedonthatInfo> mergeToSelect = new StdSchedonthatMergeToSelect(option);
		ActionLazy<SchedonthatInfo> mergeMonth = new LazySchedonthatMergeMonth(option.conn, option.schemaName);
		ActionLazy<SchedonthatInfo> enforceWeekday = new LazySchedonthatEnforceWeekday(option.conn, option.schemaName);
		ActionLazy<SchedonthatInfo> mergeWeekday = new LazySchedonthatMergeWeekday(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeMonth);
		mergeMonth.addPostAction(enforceWeekday);
		enforceWeekday.addPostAction(mergeWeekday);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
