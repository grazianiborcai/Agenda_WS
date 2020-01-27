package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.action.StdLanguSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
		
		ActionStd<LanguInfo> select = new StdLanguSelect(option);
		
		actions.add(select);
		return actions;
	}
}
