package br.com.mind5.business.scheduleMoviment.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.model.action.LazySchedovmEnforceCancel;
import br.com.mind5.business.scheduleMoviment.model.action.LazySchedovmEnforceReverse;
import br.com.mind5.business.scheduleMoviment.model.action.LazySchedovmEnforceZero;
import br.com.mind5.business.scheduleMoviment.model.action.LazySchedovmNodeInsert;
import br.com.mind5.business.scheduleMoviment.model.action.StdSchedovmEnforceCounter;
import br.com.mind5.business.scheduleMoviment.model.checker.SchedovmCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootSchedovmInsert extends DeciTreeWriteTemplate<SchedovmInfo> {
	
	public RootSchedovmInsert(DeciTreeOption<SchedovmInfo> option) {
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
		checker = new SchedovmCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedovmInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedovmInfo> option) {
		List<ActionStdV1<SchedovmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedovmInfo> enforceCounter = new StdSchedovmEnforceCounter(option);
		ActionLazyV1<SchedovmInfo> enforceZero = new LazySchedovmEnforceZero(option.conn, option.schemaName);
		ActionLazyV1<SchedovmInfo> enforceCancel = new LazySchedovmEnforceCancel(option.conn, option.schemaName);
		ActionLazyV1<SchedovmInfo> enforceReverse = new LazySchedovmEnforceReverse(option.conn, option.schemaName);
		ActionLazyV1<SchedovmInfo> nodeInsert = new LazySchedovmNodeInsert(option.conn, option.schemaName);
		
		enforceCounter.addPostAction(enforceZero);
		enforceZero.addPostAction(enforceCancel);
		enforceCancel.addPostAction(enforceReverse);
		enforceReverse.addPostAction(nodeInsert);
		
		actions.add(enforceCounter);
		return actions;
	}
}
