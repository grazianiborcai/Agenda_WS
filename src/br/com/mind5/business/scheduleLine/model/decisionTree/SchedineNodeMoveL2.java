package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiRootInsertForce;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiBookiceValidate;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceRef;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedineNodeMoveL2 extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public SchedineNodeMoveL2(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> enforceRef = new ActionStdCommom<SchedineInfo>(option, SchedineVisiEnforceRef.class);
		ActionLazy<SchedineInfo> bookiceValidate = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiBookiceValidate.class);
		ActionLazy<SchedineInfo> insert = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiRootInsertForce.class);
		
		enforceRef.addPostAction(bookiceValidate);
		bookiceValidate.addPostAction(insert);
		
		actions.add(enforceRef);
		return actions;
	}
}
