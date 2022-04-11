package br.com.mind5.business.orderItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.action.OrdemarchVisiRootSelect;
import br.com.mind5.business.orderItemSearch.model.action.OrdemarchVisiEnforceOrderKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrdemarchRootSelectOrder extends DeciTreeTemplateWrite<OrdemarchInfo> {
	
	public OrdemarchRootSelectOrder(DeciTreeOption<OrdemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemarchInfo> buildCheckerHook(DeciTreeOption<OrdemarchInfo> option) {
		List<ModelChecker<OrdemarchInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemarchInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemarchInfo> option) {
		List<ActionStd<OrdemarchInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemarchInfo> enforceOrderKey = new ActionStdCommom<OrdemarchInfo>(option, OrdemarchVisiEnforceOrderKey.class);
		ActionLazy<OrdemarchInfo> select = new ActionLazyCommom<OrdemarchInfo>(option, OrdemarchVisiRootSelect.class);
		
		enforceOrderKey.addPostAction(select);
		
		actions.add(enforceOrderKey);
		return actions;
	}
}
