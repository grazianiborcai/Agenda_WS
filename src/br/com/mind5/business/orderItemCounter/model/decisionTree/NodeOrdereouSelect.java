package br.com.mind5.business.orderItemCounter.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemCounter.info.OrdereouInfo;
import br.com.mind5.business.orderItemCounter.model.action.LazyOrdereouEnforceItemCounter;
import br.com.mind5.business.orderItemCounter.model.action.LazyOrdereouObfuscateOrdemist;
import br.com.mind5.business.orderItemCounter.model.action.StdOrdereouEnforceItemCounter;
import br.com.mind5.business.orderItemCounter.model.action.StdOrdereouMergeOrdemist;
import br.com.mind5.business.orderItemCounter.model.checker.OrdereouCheckOrdemarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeOrdereouSelect extends DeciTreeTemplateRead<OrdereouInfo> {
	
	public NodeOrdereouSelect(DeciTreeOption<OrdereouInfo> option) {
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
		
		ActionStd<OrdereouInfo> mergeOrdemist = new StdOrdereouMergeOrdemist(option);
		ActionLazy<OrdereouInfo> enforceItemCounter = new LazyOrdereouEnforceItemCounter(option.conn, option.schemaName);
		ActionLazy<OrdereouInfo> obfuscateOrdemist = new LazyOrdereouObfuscateOrdemist(option.conn, option.schemaName);
		
		mergeOrdemist.addPostAction(enforceItemCounter);
		enforceItemCounter.addPostAction(obfuscateOrdemist);
		
		actions.add(mergeOrdemist);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrdereouInfo>> buildActionsOnFailedHook(DeciTreeOption<OrdereouInfo> option) {
		List<ActionStd<OrdereouInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdereouInfo> enforceItemCounter = new StdOrdereouEnforceItemCounter(option);
		ActionLazy<OrdereouInfo> obfuscateCartem = new LazyOrdereouObfuscateOrdemist(option.conn, option.schemaName);
		
		enforceItemCounter.addPostAction(obfuscateCartem);
		
		actions.add(enforceItemCounter);	
		return actions;
	}
}
