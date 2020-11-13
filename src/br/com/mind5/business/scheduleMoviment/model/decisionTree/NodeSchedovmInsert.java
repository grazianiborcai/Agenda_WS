package br.com.mind5.business.scheduleMoviment.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.model.action.StdSchedovmDaoInsert;
import br.com.mind5.business.scheduleMoviment.model.action.StdSchedovmSuccess;
import br.com.mind5.business.scheduleMoviment.model.checker.SchedovmCheckHasCounter;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSchedovmInsert extends DeciTreeTemplateWrite<SchedovmInfo> {
	
	public NodeSchedovmInsert(DeciTreeOption<SchedovmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedovmInfo> buildCheckerHook(DeciTreeOption<SchedovmInfo> option) {
		List<ModelChecker<SchedovmInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedovmInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedovmCheckHasCounter(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedovmInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedovmInfo> option) {
		List<ActionStd<SchedovmInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedovmInfo> insert = new StdSchedovmDaoInsert(option);
		
		actions.add(insert);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedovmInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedovmInfo> option) {
		List<ActionStd<SchedovmInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedovmInfo> success = new StdSchedovmSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
