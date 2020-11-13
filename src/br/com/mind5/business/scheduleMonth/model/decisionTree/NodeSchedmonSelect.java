package br.com.mind5.business.scheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.model.action.LazySchedmonMergeCalate;
import br.com.mind5.business.scheduleMonth.model.action.LazySchedmonMergeEmplis;
import br.com.mind5.business.scheduleMonth.model.action.LazySchedmonMergeMatlis;
import br.com.mind5.business.scheduleMonth.model.action.LazySchedmonMergeStolis;
import br.com.mind5.business.scheduleMonth.model.action.StdSchedmonMergeCalate;
import br.com.mind5.business.scheduleMonth.model.action.StdSchedmonMergeSchedonthat;
import br.com.mind5.business.scheduleMonth.model.checker.SchedmonCheckSchedonthat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSchedmonSelect extends DeciTreeTemplateWrite<SchedmonInfo> {
	
	public NodeSchedmonSelect(DeciTreeOption<SchedmonInfo> option) {
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
		
		ActionStd<SchedmonInfo> mergeSchedonthat = new StdSchedmonMergeSchedonthat(option);
		ActionLazy<SchedmonInfo> mergeStolis = new LazySchedmonMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedmonInfo> mergeMatlis = new LazySchedmonMergeMatlis(option.conn, option.schemaName);
		ActionLazy<SchedmonInfo> mergeEmplis = new LazySchedmonMergeEmplis(option.conn, option.schemaName);
		ActionLazy<SchedmonInfo> mergeCalate = new LazySchedmonMergeCalate(option.conn, option.schemaName);
		
		mergeSchedonthat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeCalate);
		
		actions.add(mergeSchedonthat);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedmonInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStd<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedmonInfo> mergeCalate = new StdSchedmonMergeCalate(option);
		
		actions.add(mergeCalate);
		return actions;
	}
}
