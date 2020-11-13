package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.LazyCartEnforceLChanged;
import br.com.mind5.business.cart.model.action.LazyCartNodeUpsert;
import br.com.mind5.business.cart.model.action.LazyCartNodeUpsertHeader;
import br.com.mind5.business.cart.model.action.LazyCartNodeUpsertItem;
import br.com.mind5.business.cart.model.action.StdCartMergeUsername;
import br.com.mind5.business.cart.model.checker.CartCheckLangu;
import br.com.mind5.business.cart.model.checker.CartCheckOwner;
import br.com.mind5.business.cart.model.checker.CartCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCartUpsert extends DeciTreeTemplateWriteV2<CartInfo> {
	
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
		//TODO: verificar Ordem em aberto		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStdV2<CartInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CartInfo> mergeUsername = new StdCartMergeUsername(option);
		ActionLazy<CartInfo> enforceLChanged = new LazyCartEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<CartInfo> upsertHeader = new LazyCartNodeUpsertHeader(option.conn, option.schemaName);
		ActionLazy<CartInfo> upsertItem = new LazyCartNodeUpsertItem(option.conn, option.schemaName);
		ActionLazy<CartInfo> nodeL1 = new LazyCartNodeUpsert(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(upsertHeader);
		upsertHeader.addPostAction(upsertItem);
		upsertItem.addPostAction(nodeL1);
		
		actions.add(mergeUsername);
		return actions;
	}
}
