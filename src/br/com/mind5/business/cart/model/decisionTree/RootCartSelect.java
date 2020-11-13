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
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCartSelect extends DeciTreeTemplateReadV2<CartInfo> {
	
	public RootCartSelect(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartInfo> buildCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelCheckerV1<CartInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStdV2<CartInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<CartInfo> mergeUser = new StdCartMergeUsername(option);
		ActionLazy<CartInfo> select = new LazyCartMergeToSelect(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeCartem = new LazyCartMergeCartem(option.conn, option.schemaName);
		ActionLazy<CartInfo> enforceCurrency = new LazyCartEnforceCurrency(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeCurrency = new LazyCartMergeCurrency(option.conn, option.schemaName);
		ActionLazy<CartInfo> mergeFeewner = new LazyCartMergeFeewner(option.conn, option.schemaName);
		ActionLazy<CartInfo> enforceItemtotal = new LazyCartEnforceItemtotal(option.conn, option.schemaName);
		ActionLazy<CartInfo> enforceGrantotal = new LazyCartEnforceGrantotal(option.conn, option.schemaName);
		
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
