package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeEmplis;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeMat;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeScheduleStatus;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeStolis;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeWeekday;
import br.com.gda.business.scheduleLine.model.action.StdSchedineMergeToSelect;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckLangu;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedineSelect extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public RootSchedineSelect(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new SchedineCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> select = new StdSchedineMergeToSelect(option);
		ActionLazy<SchedineInfo> mergeMat = new LazySchedineMergeMat(option.conn, option.schemaName);	
		ActionLazy<SchedineInfo> mergeStolis = new LazySchedineMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeEmplis = new LazySchedineMergeEmplis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeStatus = new LazySchedineMergeScheduleStatus(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeWeekday = new LazySchedineMergeWeekday(option.conn, option.schemaName);
		
		select.addPostAction(mergeMat);
		mergeMat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeStatus);
		mergeStatus.addPostAction(mergeWeekday);
		
		actions.add(select);
		return actions;
	}
}
