package br.com.mind5.business.scheduleYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.action.LazySchedyearRootSelect;
import br.com.mind5.business.scheduleYear.model.action.StdSchedyearEnforceNext;
import br.com.mind5.business.scheduleYear.model.checker.SchedyearCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedyearSelectNext extends DeciTreeTemplateWrite<SchedyearInfo> {
	
	public RootSchedyearSelectNext(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedyearInfo> buildCheckerHook(DeciTreeOption<SchedyearInfo> option) {
		List<ModelChecker<SchedyearInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedyearInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedyearCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedyearInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStd<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedyearInfo> enforceNext = new StdSchedyearEnforceNext(option);
		ActionLazy<SchedyearInfo> select = new LazySchedyearRootSelect(option.conn, option.schemaName);

		enforceNext.addPostAction(select);
		
		actions.add(enforceNext);
		return actions;
	}
}
