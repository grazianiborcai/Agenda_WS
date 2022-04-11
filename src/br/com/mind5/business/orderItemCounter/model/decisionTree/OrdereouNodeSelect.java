package br.com.mind5.business.orderItemCounter.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderItemCounter.model.action.OrdereouVisiEnforceItemCounter;
import br.com.mind5.business.orderItemCounter.model.action.OrdereouVisiMergeOrdemarch;
import br.com.mind5.business.orderItemCounter.model.action.OrdereouVisiObfuscateOrdemist;
import br.com.mind5.business.orderItemCounter.model.checker.OrdereouCheckOrdemarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdereouNodeSelect extends DeciTreeTemplateRead<OrdereouInfo> {
	
	public OrdereouNodeSelect(DeciTreeOption<OrdereouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdereouInfo> buildCheckerHook(DeciTreeOption<OrdereouInfo> option) {
		List<ModelChecker<OrdereouInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdereouInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdereouCheckOrdemarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdereouInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdereouInfo> option) {
		List<ActionStd<OrdereouInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdereouInfo> mergeOrdemarch = new ActionStdCommom<OrdereouInfo>(option, OrdereouVisiMergeOrdemarch.class);
		ActionLazy<OrdereouInfo> enforceItemCounter = new ActionLazyCommom<OrdereouInfo>(option, OrdereouVisiEnforceItemCounter.class);
		ActionLazy<OrdereouInfo> obfuscateOrdemist = new ActionLazyCommom<OrdereouInfo>(option, OrdereouVisiObfuscateOrdemist.class);
		
		mergeOrdemarch.addPostAction(enforceItemCounter);
		enforceItemCounter.addPostAction(obfuscateOrdemist);
		
		actions.add(mergeOrdemarch);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrdereouInfo>> buildActionsOnFailedHook(DeciTreeOption<OrdereouInfo> option) {
		List<ActionStd<OrdereouInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdereouInfo> enforceItemCounter = new ActionStdCommom<OrdereouInfo>(option, OrdereouVisiEnforceItemCounter.class);
		ActionLazy<OrdereouInfo> obfuscateCartem = new ActionLazyCommom<OrdereouInfo>(option, OrdereouVisiObfuscateOrdemist.class);
		
		enforceItemCounter.addPostAction(obfuscateCartem);
		
		actions.add(enforceItemCounter);	
		return actions;
	}
}
