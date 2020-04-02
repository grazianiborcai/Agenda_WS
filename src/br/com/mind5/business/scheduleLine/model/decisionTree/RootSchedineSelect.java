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
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
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
	
	
	
	@Override protected List<ActionStdV1<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV1<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedineInfo> select = new StdSchedineMergeToSelect(option);
		ActionLazyV1<SchedineInfo> mergeMatlis = new LazySchedineMergeMatlis(option.conn, option.schemaName);	
		ActionLazyV1<SchedineInfo> mergeStolis = new LazySchedineMergeStolis(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> mergeEmplis = new LazySchedineMergeEmplis(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> mergeStatus = new LazySchedineMergeScheduleStatus(option.conn, option.schemaName);
		ActionLazyV1<SchedineInfo> mergeWeekday = new LazySchedineMergeWeekday(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeStatus);
		mergeStatus.addPostAction(mergeWeekday);
		
		actions.add(select);
		return actions;
	}
}
