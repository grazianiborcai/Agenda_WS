package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.LazyCartUpsertCartem;
import br.com.mind5.business.cart.model.action.StdCartEnforceCartemKey;
import br.com.mind5.business.cart.model.checker.CartCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartCartem extends DeciTreeWriteTemplate<CartInfo> {
	
	public NodeCartCartem(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		
		checker = new CartCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStdV1<CartInfo>> actions = new ArrayList<>();		

		ActionStdV1<CartInfo> enforceCartemKey = new StdCartEnforceCartemKey(option);
		ActionLazyV1<CartInfo> upsertCartem = new LazyCartUpsertCartem(option.conn, option.schemaName);
		
		enforceCartemKey.addPostAction(upsertCartem);
		
		actions.add(enforceCartemKey);
		return actions;
	}
}
