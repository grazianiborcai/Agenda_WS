package br.com.mind5.business.scheduleDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeCuslis;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeEmplis;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeMatlis;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeMonth;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeMooncal;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeSchedatus;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeStolis;
import br.com.mind5.business.scheduleDay.model.action.LazySchedayMergeWeekday;
import br.com.mind5.business.scheduleDay.model.action.StdSchedayMergeSchedayta;
import br.com.mind5.business.scheduleDay.model.checker.SchedayCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedaySelect extends DeciTreeTemplateWriteV2<SchedayInfo> {
	
	public RootSchedaySelect(DeciTreeOption<SchedayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedayInfo> buildCheckerHook(DeciTreeOption<SchedayInfo> option) {
		List<ModelCheckerV1<SchedayInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedayInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedayCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedayInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedayInfo> option) {
		List<ActionStdV1<SchedayInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedayInfo> mergeSchedayta = new StdSchedayMergeSchedayta(option);
		ActionLazyV1<SchedayInfo> mergeStolis = new LazySchedayMergeStolis(option.conn, option.schemaName);
		ActionLazyV1<SchedayInfo> mergeMatlis = new LazySchedayMergeMatlis(option.conn, option.schemaName);
		ActionLazyV1<SchedayInfo> mergeEmplis = new LazySchedayMergeEmplis(option.conn, option.schemaName);
		ActionLazyV1<SchedayInfo> mergeCuslis = new LazySchedayMergeCuslis(option.conn, option.schemaName);
		ActionLazyV1<SchedayInfo> mergeSchedatus = new LazySchedayMergeSchedatus(option.conn, option.schemaName);
		ActionLazyV1<SchedayInfo> mergeMonth = new LazySchedayMergeMonth(option.conn, option.schemaName);
		ActionLazyV1<SchedayInfo> mergeWeekday = new LazySchedayMergeWeekday(option.conn, option.schemaName);
		ActionLazyV1<SchedayInfo> mergeMooncal = new LazySchedayMergeMooncal(option.conn, option.schemaName);
		
		mergeSchedayta.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeSchedatus);
		mergeSchedatus.addPostAction(mergeMonth);
		mergeMonth.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeMooncal);
		
		actions.add(mergeSchedayta);
		return actions;
	}
}
