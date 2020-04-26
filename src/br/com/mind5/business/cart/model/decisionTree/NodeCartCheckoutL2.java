package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.LazyCartRootDelete;
import br.com.mind5.business.cart.model.action.StdCartInsertOrder;
import br.com.mind5.business.cart.model.checker.CartCheckAged;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCartCheckoutL2 extends DeciTreeTemplateWriteV2<CartInfo> {
	
	public NodeCartCheckoutL2(DeciTreeOption<CartInfo> option) {
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
		checker = new CartCheckAged(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStdV1<CartInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartInfo> insertOrder = new StdCartInsertOrder(option);	
		ActionLazyV1<CartInfo> delete = new LazyCartRootDelete(option.conn, option.schemaName);
		
		insertOrder.addPostAction(delete);
		
		actions.add(insertOrder);
		return actions;
	}
}
