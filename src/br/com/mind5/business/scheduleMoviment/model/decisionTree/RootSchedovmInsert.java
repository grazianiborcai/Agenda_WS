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
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootSchedovmInsert extends DeciTreeTemplateWriteV2<SchedovmInfo> {
	
	public RootSchedovmInsert(DeciTreeOption<SchedovmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SchedovmInfo> buildCheckerHook(DeciTreeOption<SchedovmInfo> option) {
		List<ModelCheckerV1<SchedovmInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SchedovmInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedovmCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SchedovmInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedovmInfo> option) {
		List<ActionStdV1<SchedovmInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SchedovmInfo> enforceCounter = new StdSchedovmEnforceCounter(option);
		ActionLazy<SchedovmInfo> enforceZero = new LazySchedovmEnforceZero(option.conn, option.schemaName);
		ActionLazy<SchedovmInfo> enforceCancel = new LazySchedovmEnforceCancel(option.conn, option.schemaName);
		ActionLazy<SchedovmInfo> enforceReverse = new LazySchedovmEnforceReverse(option.conn, option.schemaName);
		ActionLazy<SchedovmInfo> nodeInsert = new LazySchedovmNodeInsert(option.conn, option.schemaName);
		
		enforceCounter.addPostAction(enforceZero);
		enforceZero.addPostAction(enforceCancel);
		enforceCancel.addPostAction(enforceReverse);
		enforceReverse.addPostAction(nodeInsert);
		
		actions.add(enforceCounter);
		return actions;
	}
}
