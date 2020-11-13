package br.com.mind5.business.scheduleDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeCalate;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeCalimore;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeCuslis;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeEmplis;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeMatlis;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeSchedatus;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeStolis;
import br.com.mind5.business.scheduleDay.model.action.StdSchedayMergeCalate;
import br.com.mind5.business.scheduleDay.model.action.StdSchedayMergeSchedayta;
import br.com.mind5.business.scheduleDay.model.checker.SchedayCheckSchedayta;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSchedaySelect extends DeciTreeTemplateWrite<SchedayInfo> {
	
	public NodeSchedaySelect(DeciTreeOption<SchedayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedayInfo> buildCheckerHook(DeciTreeOption<SchedayInfo> option) {
		List<ModelChecker<SchedayInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedayInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedayCheckSchedayta(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedayInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedayInfo> option) {
		List<ActionStd<SchedayInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedayInfo> mergeSchedayta = new StdSchedayMergeSchedayta(option);
		ActionLazy<SchedayInfo> mergeStolis = new LazySchedayMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedayInfo> mergeMatlis = new LazySchedayMergeMatlis(option.conn, option.schemaName);
		ActionLazy<SchedayInfo> mergeEmplis = new LazySchedayMergeEmplis(option.conn, option.schemaName);
		ActionLazy<SchedayInfo> mergeCuslis = new LazySchedayMergeCuslis(option.conn, option.schemaName);
		ActionLazy<SchedayInfo> mergeSchedatus = new LazySchedayMergeSchedatus(option.conn, option.schemaName);
		ActionLazy<SchedayInfo> mergeCalate = new LazySchedayMergeCalate(option.conn, option.schemaName);
		ActionLazy<SchedayInfo> mergeCalimore = new LazySchedayMergeCalimore(option.conn, option.schemaName);
		
		mergeSchedayta.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeSchedatus);
		mergeSchedatus.addPostAction(mergeCalate);
		mergeCalate.addPostAction(mergeCalimore);
		
		actions.add(mergeSchedayta);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedayInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedayInfo> option) {
		List<ActionStd<SchedayInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedayInfo> mergeCalate = new StdSchedayMergeCalate(option);
		ActionLazy<SchedayInfo> mergeCalimore = new LazySchedayMergeCalimore(option.conn, option.schemaName);
		
		mergeCalate.addPostAction(mergeCalimore);
		
		actions.add(mergeCalate);
		return actions;
	} 
}
