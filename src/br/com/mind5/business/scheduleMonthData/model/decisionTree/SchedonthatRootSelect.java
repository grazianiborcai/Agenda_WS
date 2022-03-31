package br.com.mind5.business.scheduleMonthData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.action.SchedonthatVisiEnforceWeekday;
import br.com.mind5.business.scheduleMonthData.model.action.SchedonthatVisiMergeToSelect;
import br.com.mind5.business.scheduleMonthData.model.checker.SchedonthatCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedonthatRootSelect extends DeciTreeTemplateWrite<SchedonthatInfo> {
	
	public SchedonthatRootSelect(DeciTreeOption<SchedonthatInfo> option) {
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
		
		ActionStd<SchedonthatInfo> mergeToSelect = new ActionStdCommom<SchedonthatInfo>(option, SchedonthatVisiMergeToSelect.class);
		ActionLazy<SchedonthatInfo> enforceWeekday = new ActionLazyCommom<SchedonthatInfo>(option, SchedonthatVisiEnforceWeekday.class);
		
		mergeToSelect.addPostAction(enforceWeekday);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
