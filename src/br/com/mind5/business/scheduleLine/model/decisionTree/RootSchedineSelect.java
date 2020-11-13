package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeEmplis;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeMatlis;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeSchedatus;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeStolis;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeWeekday;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineMergeToSelect;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckLangu;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckOwner;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedineSelect extends DeciTreeTemplateWriteV2<SchedineInfo> {
	
	public RootSchedineSelect(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelCheckerV1<SchedineInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedineInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStdV1<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedineInfo> select = new StdSchedineMergeToSelect(option);
		ActionLazy<SchedineInfo> mergeMatlis = new LazySchedineMergeMatlis(option.conn, option.schemaName);	
		ActionLazy<SchedineInfo> mergeStolis = new LazySchedineMergeStolis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeEmplis = new LazySchedineMergeEmplis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeStatus = new LazySchedineMergeSchedatus(option.conn, option.schemaName);
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
