package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.LazyCartUpsertCartem;
import br.com.mind5.business.cart.model.action.StdCartEnforceCartemKey;
import br.com.mind5.business.cart.model.checker.CartCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartCartem extends DeciTreeWriteTemplate<CartInfo> {
	
	public NodeCartCartem(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildDecisionCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		
		checker = new CartCheckWrite();
		queue.add(checker);
		//TODO: has item ?
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
