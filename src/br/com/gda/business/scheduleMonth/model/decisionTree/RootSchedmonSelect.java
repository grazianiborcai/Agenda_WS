package br.com.gda.business.scheduleMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.business.scheduleMonth.model.action.LazySchedmonMergeEmplis;
import br.com.gda.business.scheduleMonth.model.action.LazySchedmonMergeMat;
import br.com.gda.business.scheduleMonth.model.action.LazySchedmonMergeStolis;
import br.com.gda.business.scheduleMonth.model.action.StdSchedyearMergeSchedonthat;
import br.com.gda.business.scheduleMonth.model.checker.SchedmonCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedmonSelect extends DeciTreeWriteTemplate<SchedmonInfo> {
	
	public RootSchedmonSelect(DeciTreeOption<SchedmonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedmonInfo> buildDecisionCheckerHook(DeciTreeOption<SchedmonInfo> option) {
		List<ModelChecker<SchedmonInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedmonInfo> checker;	
		
		checker = new SchedmonCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedmonInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedmonInfo> option) {
		List<ActionStd<SchedmonInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedmonInfo> mergeSchedonthat = new StdSchedyearMergeSchedonthat(option);
		ActionLazy<SchedmonInfo> mergeStolis = new LazySchedmonMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedmonInfo> mergeMat = new LazySchedmonMergeMat(option.conn, option.schemaName);
		ActionLazy<SchedmonInfo> mergeEmplis = new LazySchedmonMergeEmplis(option.conn, option.schemaName);
		
		mergeSchedonthat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMat);
		mergeMat.addPostAction(mergeEmplis);
		
		actions.add(mergeSchedonthat);
		return actions;
	}
}
