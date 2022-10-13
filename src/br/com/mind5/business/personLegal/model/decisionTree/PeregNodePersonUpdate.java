package br.com.mind5.business.personLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.action.PeregVisiPersonUpdate;
import br.com.mind5.business.personLegal.model.action.PeregVisiEnforcePersonKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PeregNodePersonUpdate extends DeciTreeTemplateWrite<PeregInfo> {
	
	public PeregNodePersonUpdate(DeciTreeOption<PeregInfo> option) {
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
		
		ActionStd<PeregInfo> enforcePersonKey = new ActionStdCommom<PeregInfo>(option, PeregVisiEnforcePersonKey.class);
		ActionLazy<PeregInfo> updatePerson = new ActionLazyCommom<PeregInfo>(option, PeregVisiPersonUpdate.class);
		
		enforcePersonKey.addPostAction(updatePerson);
		
		actions.add(enforcePersonKey);
		return actions;
	}
}
