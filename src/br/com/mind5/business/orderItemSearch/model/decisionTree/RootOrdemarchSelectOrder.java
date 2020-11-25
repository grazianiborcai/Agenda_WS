package br.com.mind5.business.orderItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.action.LazyOrdemarchRootSelect;
import br.com.mind5.business.orderItemSearch.model.action.StdOrdemarchEnforceOrderKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootOrdemarchSelectOrder extends DeciTreeTemplateWrite<OrdemarchInfo> {
	
	public RootOrdemarchSelectOrder(DeciTreeOption<OrdemarchInfo> option) {
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
		
		ActionStd<OrdemarchInfo> enforceOrderKey = new StdOrdemarchEnforceOrderKey(option);
		ActionLazy<OrdemarchInfo> select = new LazyOrdemarchRootSelect(option.conn, option.schemaName);
		
		enforceOrderKey.addPostAction(select);
		
		actions.add(enforceOrderKey);
		return actions;
	}
}
