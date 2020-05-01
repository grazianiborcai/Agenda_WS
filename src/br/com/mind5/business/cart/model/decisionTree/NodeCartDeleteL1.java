package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.StdCartDeleteCartem;
import br.com.mind5.business.cart.model.checker.CartCheckCartemarch;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCartDeleteL1 extends DeciTreeTemplateWriteV2<CartInfo> {
	
	public NodeCartDeleteL1(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartInfo> buildCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelCheckerV1<CartInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartCheckCartemarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStdV1<CartInfo>> actions = new ArrayList<>();		

		ActionStdV1<CartInfo> deleteCartem = new StdCartDeleteCartem(option);
		ActionStdV1<CartInfo> nodeL2 = new NodeCartDeleteL2(option).toAction();
		
		actions.add(deleteCartem);
		actions.add(nodeL2);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<CartInfo>> buildActionsOnFailedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStdV1<CartInfo>> actions = new ArrayList<>();		

		ActionStdV1<CartInfo> nodeL2 = new NodeCartDeleteL2(option).toAction();
		
		actions.add(nodeL2);		
		return actions;
	}
}
