package br.com.mind5.business.cartCounter.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.cartCounter.model.action.LazyCartouEnforceItemCounter;
import br.com.mind5.business.cartCounter.model.action.LazyCartouObfuscateCartem;
import br.com.mind5.business.cartCounter.model.action.StdCartouEnforceItemCounter;
import br.com.mind5.business.cartCounter.model.action.StdCartouMergeCartem;
import br.com.mind5.business.cartCounter.model.checker.CartouCheckCartem;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeCartouSelect extends DeciTreeTemplateRead<CartouInfo> {
	
	public NodeCartouSelect(DeciTreeOption<CartouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartouInfo> buildCheckerHook(DeciTreeOption<CartouInfo> option) {
		List<ModelChecker<CartouInfo>> queue = new ArrayList<>();		
		ModelChecker<CartouInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartouCheckCartem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartouInfo>> buildActionsOnPassedHook(DeciTreeOption<CartouInfo> option) {
		List<ActionStd<CartouInfo>> actions = new ArrayList<>();		
		
		ActionStd<CartouInfo> mergeCartem = new StdCartouMergeCartem(option);
		ActionLazy<CartouInfo> enforceItemCounter = new LazyCartouEnforceItemCounter(option.conn, option.schemaName);
		ActionLazy<CartouInfo> obfuscateCartem = new LazyCartouObfuscateCartem(option.conn, option.schemaName);
		
		mergeCartem.addPostAction(enforceItemCounter);
		enforceItemCounter.addPostAction(obfuscateCartem);
		
		actions.add(mergeCartem);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CartouInfo>> buildActionsOnFailedHook(DeciTreeOption<CartouInfo> option) {
		List<ActionStd<CartouInfo>> actions = new ArrayList<>();		
		
		ActionStd<CartouInfo> enforceItemCounter = new StdCartouEnforceItemCounter(option);
		ActionLazy<CartouInfo> obfuscateCartem = new LazyCartouObfuscateCartem(option.conn, option.schemaName);
		
		enforceItemCounter.addPostAction(obfuscateCartem);
		
		actions.add(enforceItemCounter);	
		return actions;
	}
}
