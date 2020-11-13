package br.com.mind5.business.scheduleYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.action.LazySchedyearRootSelect;
import br.com.mind5.business.scheduleYear.model.action.StdSchedyearEnforceNow;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedyearSelectNow extends DeciTreeTemplateWrite<SchedyearInfo> {
	
	public RootSchedyearSelectNow(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedyearInfo> buildCheckerHook(DeciTreeOption<SchedyearInfo> option) {
		List<ModelChecker<SchedyearInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedyearInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedyearInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedyearInfo> option) {
		List<ActionStd<SchedyearInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedyearInfo> enforceNow = new StdSchedyearEnforceNow(option);
		ActionLazy<SchedyearInfo> select = new LazySchedyearRootSelect(option.conn, option.schemaName);

		enforceNow.addPostAction(select);
		
		actions.add(enforceNow);
		return actions;
	}
}
