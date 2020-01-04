package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.LazyCartEnforceObfuscate;
import br.com.mind5.business.cart.model.action.LazyCartInsertOrder;
import br.com.mind5.business.cart.model.action.LazyCartRootDelete;
import br.com.mind5.business.cart.model.checker.CartCheckExist;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartCheckout extends DeciTreeWriteTemplate<CartInfo> {
	
	public NodeCartCheckout(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildDecisionCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartCheckExist(checkerOption);
		queue.add(checker);
		//TODO: has item ?
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();
		
		ActionStd<CartInfo> select = new RootCartSelect(option).toAction();
		ActionLazy<CartInfo> insertOrder = new LazyCartInsertOrder(option.conn, option.schemaName);	
		ActionLazy<CartInfo> delete = new LazyCartRootDelete(option.conn, option.schemaName);	
		ActionLazy<CartInfo> obfuscate = new LazyCartEnforceObfuscate(option.conn, option.schemaName);	
		
		select.addPostAction(insertOrder);
		insertOrder.addPostAction(delete);
		insertOrder.addPostAction(obfuscate);
		
		actions.add(select);
		return actions;
	}
}
