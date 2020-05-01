package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.LazyCartUpsertCartem;
import br.com.mind5.business.cart.model.action.StdCartEnforceCartemKey;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCartUpsertItem extends DeciTreeTemplateWriteV2<CartInfo> {
	
	public NodeCartUpsertItem(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartInfo> buildCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelCheckerV1<CartInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStdV1<CartInfo>> actions = new ArrayList<>();		

		ActionStdV1<CartInfo> enforceCartemKey = new StdCartEnforceCartemKey(option);
		ActionLazyV1<CartInfo> upsertCartem = new LazyCartUpsertCartem(option.conn, option.schemaName);
		
		enforceCartemKey.addPostAction(upsertCartem);
		
		actions.add(enforceCartemKey);
		return actions;
	}
}
