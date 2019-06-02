package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.LazyCartUpsertCartem;
import br.com.gda.business.cart.model.action.StdCartEnforceCartemKey;
import br.com.gda.business.cart.model.checker.CartCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartCartem extends DeciTreeWriteTemplate<CartInfo> {
	
	public NodeCartCartem(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildDecisionCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		
		checker = new CartCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();		

		ActionStd<CartInfo> enforceCartemKey = new StdCartEnforceCartemKey(option);
		ActionLazy<CartInfo> upsertCartem = new LazyCartUpsertCartem(option.conn, option.schemaName);
		
		enforceCartemKey.addPostAction(upsertCartem);
		
		actions.add(enforceCartemKey);
		return actions;
	}
}
