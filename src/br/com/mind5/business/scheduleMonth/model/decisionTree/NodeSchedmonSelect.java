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
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedmonSelect extends DeciTreeTemplateWriteV2<SchedmonInfo> {
	
	public NodeSchedmonSelect(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedmonInfo> buildCheckerHook(DeciTreeOption<SchedmonInfo> option) {
		List<ModelCheckerV1<SchedmonInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedmonInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedmonCheckSchedonthat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStdV1<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedmonInfo> mergeSchedonthat = new StdSchedmonMergeSchedonthat(option);
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
	
	
	
	@Override protected List<ActionStdV1<SchedmonInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStdV1<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedmonInfo> mergeCalate = new StdSchedmonMergeCalate(option);
		
		actions.add(mergeCalate);
		return actions;
	}
}
