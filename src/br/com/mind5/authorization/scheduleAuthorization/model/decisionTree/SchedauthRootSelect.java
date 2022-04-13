package br.com.mind5.authorization.scheduleAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedauthRootSelect extends DeciTreeTemplateWrite<SchedauthInfo> {
	
	public SchedauthRootSelect(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedauthInfo> buildCheckerHook(DeciTreeOption<SchedauthInfo> option) {
		List<ModelChecker<SchedauthInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedauthInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedauthInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedauthInfo> option) {
		List<ActionStd<SchedauthInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedauthInfo> forward = new SchedauthRootMove(option).toAction();
		
		actions.add(forward);
		return actions;
	}
}
