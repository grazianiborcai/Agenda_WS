package br.com.mind5.business.scheduleWeek.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeCalate;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeCalimemp;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeCalimore;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeCuslis;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeEmplis;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeMatlis;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeStolis;
import br.com.mind5.business.scheduleWeek.model.action.StdSchedeekMergeCalate;
import br.com.mind5.business.scheduleWeek.model.action.StdSchedeekMergeSchedeekdat;
import br.com.mind5.business.scheduleWeek.model.checker.SchedeekCheckSchedeekdat;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeSchedeekSelect extends DeciTreeTemplateWriteV2<SchedeekInfo> {
	
	public NodeSchedeekSelect(DeciTreeOption<SchedeekInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedeekInfo> buildCheckerHook(DeciTreeOption<SchedeekInfo> option) {
		List<ModelCheckerV1<SchedeekInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedeekInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new SchedeekCheckSchedeekdat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedeekInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekInfo> option) {
		List<ActionStdV1<SchedeekInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedeekInfo> mergeSchedeekdat = new StdSchedeekMergeSchedeekdat(option);
		ActionLazyV1<SchedeekInfo> mergeStolis = new LazySchedeekMergeStolis(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeMatlis = new LazySchedeekMergeMatlis(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeEmplis = new LazySchedeekMergeEmplis(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeCuslis = new LazySchedeekMergeCuslis(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeCalate = new LazySchedeekMergeCalate(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeCalimore = new LazySchedeekMergeCalimore(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeCalimemp = new LazySchedeekMergeCalimemp(option.conn, option.schemaName);
		
		mergeSchedeekdat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeCalate);
		mergeCalate.addPostAction(mergeCalimore);
		mergeCalimore.addPostAction(mergeCalimemp);
		
		actions.add(mergeSchedeekdat);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<SchedeekInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedeekInfo> option) {
		List<ActionStdV1<SchedeekInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedeekInfo> mergeCalate = new StdSchedeekMergeCalate(option);
		ActionLazyV1<SchedeekInfo> mergeCalimore = new LazySchedeekMergeCalimore(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeCalimemp = new LazySchedeekMergeCalimemp(option.conn, option.schemaName);
		
		mergeCalate.addPostAction(mergeCalimore);
		mergeCalimore.addPostAction(mergeCalimemp);
		
		actions.add(mergeCalate);
		return actions;
	}
}
