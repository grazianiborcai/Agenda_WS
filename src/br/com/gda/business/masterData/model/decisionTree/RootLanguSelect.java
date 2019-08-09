package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.model.action.StdLanguSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.checker.common.ModelCherckerTrue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootLanguSelect extends DeciTreeReadTemplate<LanguInfo> {
	
	public RootLanguSelect(DeciTreeOption<LanguInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<LanguInfo> buildDecisionCheckerHook(DeciTreeOption<LanguInfo> option) {
		List<ModelChecker<LanguInfo>> queue = new ArrayList<>();		
		ModelChecker<LanguInfo> checker;
		
		checker = new ModelCherckerTrue<>();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<LanguInfo>> buildActionsOnPassedHook(DeciTreeOption<LanguInfo> option) {
		List<ActionStd<LanguInfo>> actions = new ArrayList<>();
		
		actions.add(new StdLanguSelect(option));
		return actions;
	}
}
