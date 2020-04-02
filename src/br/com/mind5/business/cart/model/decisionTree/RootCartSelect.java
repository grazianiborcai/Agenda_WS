package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.LazyCartEnforceCurrency;
import br.com.mind5.business.cart.model.action.LazyCartEnforceGrantotal;
import br.com.mind5.business.cart.model.action.LazyCartEnforceItemtotal;
import br.com.mind5.business.cart.model.action.LazyCartMergeCartem;
import br.com.mind5.business.cart.model.action.LazyCartMergeCurrency;
import br.com.mind5.business.cart.model.action.LazyCartMergeFeewner;
import br.com.mind5.business.cart.model.action.LazyCartMergeToSelect;
import br.com.mind5.business.cart.model.action.StdCartMergeUsername;
import br.com.mind5.business.cart.model.checker.CartCheckLangu;
import br.com.mind5.business.cart.model.checker.CartCheckOwner;
import br.com.mind5.business.cart.model.checker.CartCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCartSelect extends DeciTreeReadTemplate<CartInfo> {
	
	public RootCartSelect(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildDecisionCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStdV1<CartInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<CartInfo> mergeUser = new StdCartMergeUsername(option);
		ActionLazyV1<CartInfo> select = new LazyCartMergeToSelect(option.conn, option.schemaName);
		ActionLazyV1<CartInfo> mergeCartem = new LazyCartMergeCartem(option.conn, option.schemaName);
		ActionLazyV1<CartInfo> enforceCurrency = new LazyCartEnforceCurrency(option.conn, option.schemaName);
		ActionLazyV1<CartInfo> mergeCurrency = new LazyCartMergeCurrency(option.conn, option.schemaName);
		ActionLazyV1<CartInfo> mergeFeewner = new LazyCartMergeFeewner(option.conn, option.schemaName);
		ActionLazyV1<CartInfo> enforceItemtotal = new LazyCartEnforceItemtotal(option.conn, option.schemaName);
		ActionLazyV1<CartInfo> enforceGrantotal = new LazyCartEnforceGrantotal(option.conn, option.schemaName);
		
		mergeUser.addPostAction(select);
		select.addPostAction(mergeCartem);
		mergeCartem.addPostAction(enforceCurrency);
		enforceCurrency.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeFeewner);		
		mergeFeewner.addPostAction(enforceItemtotal);		
		enforceItemtotal.addPostAction(enforceGrantotal);
		
		actions.add(mergeUser);			
		return actions;
	}
}
