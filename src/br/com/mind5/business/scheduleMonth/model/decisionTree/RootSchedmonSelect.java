package br.com.mind5.business.scheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.model.action.LazySchedmonMergeEmplis;
import br.com.mind5.business.scheduleMonth.model.action.LazySchedmonMergeMatlis;
import br.com.mind5.business.scheduleMonth.model.action.LazySchedmonMergeStolis;
import br.com.mind5.business.scheduleMonth.model.action.StdSchedyearMergeSchedonthat;
import br.com.mind5.business.scheduleMonth.model.checker.SchedmonCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedmonSelect extends DeciTreeWriteTemplate<SchedmonInfo> {
	
	public RootSchedmonSelect(DeciTreeOption<SchedmonInfo> option) {
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
		checker = new SchedmonCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStdV1<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedmonInfo> mergeSchedonthat = new StdSchedyearMergeSchedonthat(option);
		ActionLazyV1<SchedmonInfo> mergeStolis = new LazySchedmonMergeStolis(option.conn, option.schemaName);
		ActionLazyV1<SchedmonInfo> mergeMatlis = new LazySchedmonMergeMatlis(option.conn, option.schemaName);
		ActionLazyV1<SchedmonInfo> mergeEmplis = new LazySchedmonMergeEmplis(option.conn, option.schemaName);
		
		mergeSchedonthat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		
		actions.add(mergeSchedonthat);
		return actions;
	}
}
