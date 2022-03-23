package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.CartVisiNodeHeaderUpsert;
import br.com.mind5.business.cart.model.action.CartVisiNodeItemUpsert;
import br.com.mind5.business.cart.model.action.CartVisiNodeUpsert;
import br.com.mind5.business.cart.model.action.CartVisiEnforceExpiryOn;
import br.com.mind5.business.cart.model.action.CartVisiEnforceLChanged;
import br.com.mind5.business.cart.model.action.CartVisiMergeUsername;
import br.com.mind5.business.cart.model.checker.CartCheckLangu;
import br.com.mind5.business.cart.model.checker.CartCheckOwner;
import br.com.mind5.business.cart.model.checker.CartCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CartRootUpsert extends DeciTreeTemplateWrite<CartInfo> {
	
	public CartRootUpsert(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartCheckWrite(checkerOption);
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
		//TODO: verificar Ordem em aberto		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();
		
		ActionStd<CartInfo> mergeUsername = new ActionStdCommom<CartInfo>(option, CartVisiMergeUsername.class);
		ActionLazy<CartInfo> enforceLChanged = new ActionLazyCommom<CartInfo>(option, CartVisiEnforceLChanged.class);	
		ActionLazy<CartInfo> enforceExpiryOn = new ActionLazyCommom<CartInfo>(option, CartVisiEnforceExpiryOn.class);	
		ActionLazy<CartInfo> upsertHeader = new ActionLazyCommom<CartInfo>(option, CartVisiNodeHeaderUpsert.class);
		ActionLazy<CartInfo> upsertItem = new ActionLazyCommom<CartInfo>(option, CartVisiNodeItemUpsert.class);
		ActionLazy<CartInfo> nodeL1 = new ActionLazyCommom<CartInfo>(option, CartVisiNodeUpsert.class);
		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceExpiryOn);
		enforceExpiryOn.addPostAction(upsertHeader);
		upsertHeader.addPostAction(upsertItem);
		upsertItem.addPostAction(nodeL1);
		
		actions.add(mergeUsername);
		return actions;
	}
}
