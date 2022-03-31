package br.com.mind5.business.scheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.model.action.SchedmonVisiMergeCalate;
import br.com.mind5.business.scheduleMonth.model.action.SchedmonVisiMergeEmplres;
import br.com.mind5.business.scheduleMonth.model.action.SchedmonVisiMergeMatlis;
import br.com.mind5.business.scheduleMonth.model.action.SchedmonVisiMergeSchedonthat;
import br.com.mind5.business.scheduleMonth.model.action.SchedmonVisiMergeStolis;
import br.com.mind5.business.scheduleMonth.model.checker.SchedmonCheckSchedonthat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedmonNodeSelect extends DeciTreeTemplateWrite<SchedmonInfo> {
	
	public SchedmonNodeSelect(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedmonInfo> buildCheckerHook(DeciTreeOption<SchedmonInfo> option) {
		List<ModelChecker<SchedmonInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedmonInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedmonCheckSchedonthat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStd<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedmonInfo> mergeSchedonthat = new ActionStdCommom<SchedmonInfo>(option, SchedmonVisiMergeSchedonthat.class);
		ActionLazy<SchedmonInfo> mergeStolis = new ActionLazyCommom<SchedmonInfo>(option, SchedmonVisiMergeStolis.class);
		ActionLazy<SchedmonInfo> mergeMatlis = new ActionLazyCommom<SchedmonInfo>(option, SchedmonVisiMergeMatlis.class);
		ActionLazy<SchedmonInfo> mergeEmplres = new ActionLazyCommom<SchedmonInfo>(option, SchedmonVisiMergeEmplres.class);
		ActionLazy<SchedmonInfo> mergeCalate = new ActionLazyCommom<SchedmonInfo>(option, SchedmonVisiMergeCalate.class);
		
		mergeSchedonthat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplres);
		mergeEmplres.addPostAction(mergeCalate);
		
		actions.add(mergeSchedonthat);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedmonInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStd<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedmonInfo> mergeCalate = new ActionStdCommom<SchedmonInfo>(option, SchedmonVisiMergeCalate.class);
		
		actions.add(mergeCalate);
		return actions;
	}
}
