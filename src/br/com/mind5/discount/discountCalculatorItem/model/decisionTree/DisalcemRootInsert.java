package br.com.mind5.discount.discountCalculatorItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.discount.discountCalculatorItem.model.action.DisalcemVisiDisoupemInsert;
import br.com.mind5.discount.discountCalculatorItem.model.action.DisalcemVisiEnforceDisoupem;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class DisalcemRootInsert extends DeciTreeTemplateRead<DisalcemInfo> {
	
	public DisalcemRootInsert(DeciTreeOption<DisalcemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisalcemInfo> buildCheckerHook(DeciTreeOption<DisalcemInfo> option) {
		List<ModelChecker<DisalcemInfo>> queue = new ArrayList<>();		
		ModelChecker<DisalcemInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisalcemInfo>> buildActionsOnPassedHook(DeciTreeOption<DisalcemInfo> option) {
		List<ActionStd<DisalcemInfo>> actions = new ArrayList<>();
		
		ActionStd<DisalcemInfo> select = new DisalcemRootSelect(option).toAction();
		ActionLazy<DisalcemInfo> enforceDisoupem = new ActionLazyCommom<DisalcemInfo>(option, DisalcemVisiEnforceDisoupem.class);
		ActionLazy<DisalcemInfo> disoupemInsert = new ActionLazyCommom<DisalcemInfo>(option, DisalcemVisiDisoupemInsert.class);
		
		select.addPostAction(enforceDisoupem);
		enforceDisoupem.addPostAction(disoupemInsert);
		
		actions.add(select);
		return actions;
	}
}
