package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.StdCartEmptfyCartem;
import br.com.mind5.business.cart.model.checker.CartCheckWrite;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartEmptfy extends DeciTreeWriteTemplate<CartInfo> {
	
	public NodeCartEmptfy(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildDecisionCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		
		checker = new CartCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();		

		ActionStd<CartInfo> emptfyCartem = new StdCartEmptfyCartem(option);
		ActionStd<CartInfo> delete = new RootCartDelete(option).toAction();
		
		actions.add(emptfyCartem);
		actions.add(delete);
		
		return actions;
	}
}
