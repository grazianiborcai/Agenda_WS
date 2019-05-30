package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.LazyCartEnforceGrantotal;
import br.com.gda.business.cart.model.action.LazyCartMergeCartem;
import br.com.gda.business.cart.model.action.LazyCartMergeToSelect;
import br.com.gda.business.cart.model.action.StdCartMergeUsername;
import br.com.gda.business.cart.model.checker.CartCheckLangu;
import br.com.gda.business.cart.model.checker.CartCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootCartSelect extends DeciTreeReadTemplate<CartInfo> {
	
	public RootCartSelect(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildDecisionCheckerHook(DeciTreeOption<CartInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CartCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();		
		
		ActionStd<CartInfo> mergeUser = new StdCartMergeUsername(option);
		ActionLazy<CartInfo> select = new LazyCartMergeToSelect(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeCartem = new LazyCartMergeCartem(option.conn, option.schemaName);
		ActionLazy<CartInfo> enforceGrantotal = new LazyCartEnforceGrantotal(option.conn, option.schemaName);
		
		mergeUser.addPostAction(select);
		select.addPostAction(mergeCartem);
		mergeCartem.addPostAction(enforceGrantotal);
		
		actions.add(mergeUser);			
		return actions;
	}
}
