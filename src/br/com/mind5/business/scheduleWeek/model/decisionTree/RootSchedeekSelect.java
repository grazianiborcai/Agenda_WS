package br.com.mind5.business.scheduleWeek.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeCuslis;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeEmplis;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeMatlis;
import br.com.mind5.business.scheduleWeek.model.action.LazySchedeekMergeStolis;
import br.com.mind5.business.scheduleWeek.model.action.StdSchedeekMergeSchedeekdat;
import br.com.mind5.business.scheduleWeek.model.checker.SchedeekCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedeekSelect extends DeciTreeWriteTemplate<SchedeekInfo> {
	
	public RootSchedeekSelect(DeciTreeOption<SchedeekInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedeekInfo> buildDecisionCheckerHook(DeciTreeOption<SchedeekInfo> option) {
		List<ModelChecker<SchedeekInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedeekInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new SchedeekCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedeekInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedeekInfo> option) {
		List<ActionStdV1<SchedeekInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedeekInfo> mergeSchedeekdat = new StdSchedeekMergeSchedeekdat(option);
		ActionLazyV1<SchedeekInfo> mergeStolis = new LazySchedeekMergeStolis(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeMatlis = new LazySchedeekMergeMatlis(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeEmplis = new LazySchedeekMergeEmplis(option.conn, option.schemaName);
		ActionLazyV1<SchedeekInfo> mergeCuslis = new LazySchedeekMergeCuslis(option.conn, option.schemaName);
		
		mergeSchedeekdat.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(mergeEmplis);
		mergeEmplis.addPostAction(mergeCuslis);
		
		actions.add(mergeSchedeekdat);
		return actions;
	}
}
