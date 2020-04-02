package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.business.masterData.model.action.StdLanguSelect;
import br.com.mind5.model.action.ActionStdV1;
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
	
	
	
	@Override protected List<ActionStdV1<LanguInfo>> buildActionsOnPassedHook(DeciTreeOption<LanguInfo> option) {
		List<ActionStdV1<LanguInfo>> actions = new ArrayList<>();
		
		ActionStdV1<LanguInfo> select = new StdLanguSelect(option);
		
		actions.add(select);
		return actions;
	}
}
