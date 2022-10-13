package br.com.mind5.business.personLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.action.PeregVisiEnforcePhoneKey;
import br.com.mind5.business.personLegal.model.action.PeregVisiPhoneUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PeregNodePhoneUpdate extends DeciTreeTemplateWrite<PeregInfo> {
	
	public PeregNodePhoneUpdate(DeciTreeOption<PeregInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeregInfo> buildCheckerHook(DeciTreeOption<PeregInfo> option) {
		List<ModelChecker<PeregInfo>> queue = new ArrayList<>();		
		ModelChecker<PeregInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeregInfo>> buildActionsOnPassedHook(DeciTreeOption<PeregInfo> option) {
		List<ActionStd<PeregInfo>> actions = new ArrayList<>();
		
		ActionStd<PeregInfo> enforcePhoneKey = new ActionStdCommom<PeregInfo>(option, PeregVisiEnforcePhoneKey.class);
		ActionLazy<PeregInfo> updatePhone = new ActionLazyCommom<PeregInfo>(option, PeregVisiPhoneUpdate.class);	
		
		enforcePhoneKey.addPostAction(updatePhone);
		
		actions.add(enforcePhoneKey);		
		return actions;
	}
}
