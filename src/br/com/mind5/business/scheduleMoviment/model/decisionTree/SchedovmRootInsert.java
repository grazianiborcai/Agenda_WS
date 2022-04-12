package br.com.mind5.business.scheduleMoviment.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.model.action.SchedovmVisiNodeInsert;
import br.com.mind5.business.scheduleMoviment.model.action.SchedovmVisiEnforceCancel;
import br.com.mind5.business.scheduleMoviment.model.action.SchedovmVisiEnforceCounter;
import br.com.mind5.business.scheduleMoviment.model.action.SchedovmVisiEnforceReverse;
import br.com.mind5.business.scheduleMoviment.model.action.SchedovmVisiEnforceZero;
import br.com.mind5.business.scheduleMoviment.model.checker.SchedovmCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedovmRootInsert extends DeciTreeTemplateWrite<SchedovmInfo> {
	
	public SchedovmRootInsert(DeciTreeOption<SchedovmInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedovmInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedovmInfo> option) {
		List<ActionStd<SchedovmInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedovmInfo> enforceCounter = new ActionStdCommom<SchedovmInfo>(option, SchedovmVisiEnforceCounter.class);
		ActionLazy<SchedovmInfo> enforceZero = new ActionLazyCommom<SchedovmInfo>(option, SchedovmVisiEnforceZero.class);
		ActionLazy<SchedovmInfo> enforceCancel = new ActionLazyCommom<SchedovmInfo>(option, SchedovmVisiEnforceCancel.class);
		ActionLazy<SchedovmInfo> enforceReverse = new ActionLazyCommom<SchedovmInfo>(option, SchedovmVisiEnforceReverse.class);
		ActionLazy<SchedovmInfo> nodeInsert = new ActionLazyCommom<SchedovmInfo>(option, SchedovmVisiNodeInsert.class);
		
		enforceCounter.addPostAction(enforceZero);
		enforceZero.addPostAction(enforceCancel);
		enforceCancel.addPostAction(enforceReverse);
		enforceReverse.addPostAction(nodeInsert);
		
		actions.add(enforceCounter);
		return actions;
	}
}
