package br.com.mind5.discount.discountStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.model.action.DisorarchVisiEnforceActive;
import br.com.mind5.discount.discountStoreSearch.model.action.DisorarchVisiEnforceKey;
import br.com.mind5.discount.discountStoreSearch.model.action.DisorarchVisiEnforceValidFrom;
import br.com.mind5.discount.discountStoreSearch.model.action.DisorarchVisiEnforceValidTo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class DisorarchNodeActive extends DeciTreeTemplateRead<DisorarchInfo> {
	
	public DisorarchNodeActive(DeciTreeOption<DisorarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisorarchInfo> buildCheckerHook(DeciTreeOption<DisorarchInfo> option) {
		List<ModelChecker<DisorarchInfo>> queue = new ArrayList<>();		
		ModelChecker<DisorarchInfo> checker;
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisorarchInfo>> buildActionsOnPassedHook(DeciTreeOption<DisorarchInfo> option) {
		List<ActionStd<DisorarchInfo>> actions = new ArrayList<>();
		
		ActionStd<DisorarchInfo> enforceKey	= new ActionStdCommom<DisorarchInfo>(option, DisorarchVisiEnforceKey.class);
		ActionLazy<DisorarchInfo> enforceActive = new ActionLazyCommom<DisorarchInfo>(option, DisorarchVisiEnforceActive.class);
		ActionLazy<DisorarchInfo> enforceValidFrom = new ActionLazyCommom<DisorarchInfo>(option, DisorarchVisiEnforceValidFrom.class);
		ActionLazy<DisorarchInfo> enforceValidTo = new ActionLazyCommom<DisorarchInfo>(option, DisorarchVisiEnforceValidTo.class);
		
		enforceKey.addPostAction(enforceActive);
		enforceActive.addPostAction(enforceValidFrom);
		enforceValidFrom.addPostAction(enforceValidTo);
		
		actions.add(enforceKey);
		return actions;
	}
}
