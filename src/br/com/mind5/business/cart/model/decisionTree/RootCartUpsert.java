package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.LazyCartEnforceLChanged;
import br.com.mind5.business.cart.model.action.LazyCartNodeCartem;
import br.com.mind5.business.cart.model.action.LazyCartNodeUpsert;
import br.com.mind5.business.cart.model.action.LazyCartRootSelect;
import br.com.mind5.business.cart.model.action.StdCartMergeUsername;
import br.com.mind5.business.cart.model.checker.CartCheckLangu;
import br.com.mind5.business.cart.model.checker.CartCheckOwner;
import br.com.mind5.business.cart.model.checker.CartCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class RootCartUpsert extends DeciTreeTemplateWriteV1<CartInfo> {
	
	public RootCartUpsert(DeciTreeOption<CartInfo> option) {
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
		
		//TODO: verificar serico
		//TODO: verificar limite de itens no carrinho
		//TODO: verificar quantidade. Somente 1 para servico. Nao pode ser negativa para todos os casos
		//TODO: verificar valores negativos
		//TODO: verificar Ordem em aberto
		//TODO: Eliminar cabecalho se nao existe item ?
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStdV1<CartInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartInfo> mergeUsername = new StdCartMergeUsername(option);
		ActionLazyV1<CartInfo> enforceLChanged = new LazyCartEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<CartInfo> upsert = new LazyCartNodeUpsert(option.conn, option.schemaName);
		ActionLazyV1<CartInfo> cartem = new LazyCartNodeCartem(option.conn, option.schemaName);
		ActionLazyV1<CartInfo> select = new LazyCartRootSelect(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(upsert);
		upsert.addPostAction(cartem);
		cartem.addPostAction(select);
		
		actions.add(mergeUsername);
		return actions;
	}
}
