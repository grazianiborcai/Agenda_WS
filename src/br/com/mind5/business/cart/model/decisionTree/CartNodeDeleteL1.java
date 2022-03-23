package br.com.mind5.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.CartVisiCartemDelete;
import br.com.mind5.business.cart.model.checker.CartCheckCartemarch;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CartNodeDeleteL1 extends DeciTreeTemplateWrite<CartInfo> {
	
	public CartNodeDeleteL1(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartInfo> buildCheckerHook(DeciTreeOption<CartInfo> option) {
		List<ModelChecker<CartInfo>> queue = new ArrayList<>();		
		ModelChecker<CartInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartCheckCartemarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartInfo>> buildActionsOnPassedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();		

		ActionStd<CartInfo> deleteCartem = new ActionStdCommom<CartInfo>(option, CartVisiCartemDelete.class);
		ActionStd<CartInfo> nodeL2 = new CartNodeDeleteL2(option).toAction();
		
		actions.add(deleteCartem);
		actions.add(nodeL2);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CartInfo>> buildActionsOnFailedHook(DeciTreeOption<CartInfo> option) {
		List<ActionStd<CartInfo>> actions = new ArrayList<>();		

		ActionStd<CartInfo> nodeL2 = new CartNodeDeleteL2(option).toAction();
		
		actions.add(nodeL2);		
		return actions;
	}
}
