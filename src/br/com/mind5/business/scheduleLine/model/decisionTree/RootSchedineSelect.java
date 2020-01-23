package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeEmplis;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeMatlis;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeScheduleStatus;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeStolis;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeWeekday;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineMergeToSelect;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckLangu;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckOwner;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedineSelect extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public RootSchedineSelect(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedineCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> select = new StdSchedineMergeToSelect(option);
		ActionLazy<SchedineInfo> mergeMatlis = new LazySchedineMergeMatlis(option.conn, option.schemaName);	
		ActionLazy<SchedineInfo> mergeStolis = new LazySchedineMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeEmplis = new LazySchedineMergeEmplis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeStatus = new LazySchedineMergeScheduleStatus(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeWeekday = new LazySchedineMergeWeekday(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeStatus);
		mergeStatus.addPostAction(mergeWeekday);
		
		actions.add(select);
		return actions;
	}
}
