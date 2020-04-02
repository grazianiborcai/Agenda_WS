package br.com.mind5.business.scheduleMoviment.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.model.action.StdSchedovmInsert;
import br.com.mind5.business.scheduleMoviment.model.action.StdSchedovmSuccess;
import br.com.mind5.business.scheduleMoviment.model.checker.SchedovmCheckHasCounter;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedovmInsert extends DeciTreeWriteTemplate<SchedovmInfo> {
	
	public NodeSchedovmInsert(DeciTreeOption<SchedovmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedovmInfo> buildDecisionCheckerHook(DeciTreeOption<SchedovmInfo> option) {
		List<ModelChecker<SchedovmInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedovmInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedovmCheckHasCounter(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedovmInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedovmInfo> option) {
		List<ActionStdV1<SchedovmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedovmInfo> insert = new StdSchedovmInsert(option);
		
		actions.add(insert);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<SchedovmInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedovmInfo> option) {
		List<ActionStdV1<SchedovmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedovmInfo> success = new StdSchedovmSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
