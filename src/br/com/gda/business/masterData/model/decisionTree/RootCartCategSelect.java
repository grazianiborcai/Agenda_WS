package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.model.action.StdCartCategSelect;
import br.com.gda.business.masterData.model.checker.CartCategCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCartCategSelect extends DeciTreeReadTemplate<CartCategInfo> {
	
	public RootCartCategSelect(DeciTreeOption<CartCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartCategInfo> buildDecisionCheckerHook(DeciTreeOption<CartCategInfo> option) {
		List<ModelChecker<CartCategInfo>> queue = new ArrayList<>();		
		ModelChecker<CartCategInfo> checker;
		
		checker = new CartCategCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CartCategInfo>> buildActionsOnPassedHook(DeciTreeOption<CartCategInfo> option) {
		List<ActionStd<CartCategInfo>> actions = new ArrayList<>();
		
		actions.add(new StdCartCategSelect(option));
		return actions;
	}
}
