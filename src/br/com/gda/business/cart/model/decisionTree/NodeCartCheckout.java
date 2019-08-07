package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.LazyCartEnforceObfuscate;
import br.com.gda.business.cart.model.action.LazyCartInsertOrder;
import br.com.gda.business.cart.model.action.LazyCartNodeEmptfy;
import br.com.gda.business.cart.model.checker.CartCheckExist;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartCheckout extends DeciTreeWriteTemplate<CartInfo> {
	
	public NodeCartCheckout(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildDecisionCheckerHook(DeciTreeOption<CartInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckExist(checkerOption);
		queue.add(checker);
		//TODO: has item ?
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();
		
		ActionStd<CartInfo> select = new RootCartSelect(option).toAction();
		ActionLazy<CartInfo> insertOrder = new LazyCartInsertOrder(option.conn, option.schemaName);	
		ActionLazy<CartInfo> emptfy = new LazyCartNodeEmptfy(option.conn, option.schemaName);	
		ActionLazy<CartInfo> obfuscate = new LazyCartEnforceObfuscate(option.conn, option.schemaName);	
		
		select.addPostAction(insertOrder);
		insertOrder.addPostAction(emptfy);
		insertOrder.addPostAction(obfuscate);
		
		actions.add(select);
		return actions;
	}
}
