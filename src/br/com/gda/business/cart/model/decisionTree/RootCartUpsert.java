package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.action.StdCartMergeUsername;
import br.com.gda.business.cart.model.action.LazyCartEnforceLChanged;
import br.com.gda.business.cart.model.action.LazyCartNodeUpsert;
import br.com.gda.business.cart.model.action.LazyCartRootSelect;
import br.com.gda.business.cart.model.checker.CartCheckLangu;
import br.com.gda.business.cart.model.checker.CartCheckOwner;
import br.com.gda.business.cart.model.checker.CartCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCartUpsert extends DeciTreeWriteTemplate<CartInfo> {
	
	public RootCartUpsert(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildDecisionCheckerHook(DeciTreeOption<CartInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new CartCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new CartCheckOwner(checkerOption);
		queue.add(checker);
		
		//TODO: verificar serico
		//TODO: verificar limite de itens no carrinho
		//TODO: verificar quantidade. Somente 1 para servico. Nao pode ser negativa para todos os casos
		//TODO: verificar valores negativos
		//TODO: verificar Ordem em aberto
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();
		
		ActionStd<CartInfo> mergeUsername = new StdCartMergeUsername(option);
		ActionLazy<CartInfo> enforceLChanged = new LazyCartEnforceLChanged(option.conn, option.schemaName);		
		ActionLazy<CartInfo> upsert = new LazyCartNodeUpsert(option.conn, option.schemaName);
		ActionLazy<CartInfo> select = new LazyCartRootSelect(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(upsert);
		upsert.addPostAction(select);
		
		actions.add(mergeUsername);
		return actions;
	}
}
