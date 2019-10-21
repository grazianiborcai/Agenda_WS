package br.com.mind5.business.companySnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.model.action.StdCompnapMergeToSelect;
import br.com.mind5.business.companySnapshot.model.checker.CompnapCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCompnapSelect extends DeciTreeReadTemplate<CompnapInfo> {
	
	public RootCompnapSelect(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompnapInfo> buildDecisionCheckerHook(DeciTreeOption<CompnapInfo> option) {
		List<ModelChecker<CompnapInfo>> queue = new ArrayList<>();		
		ModelChecker<CompnapInfo> checker;
		
		checker = new CompnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompnapInfo>> buildActionsOnPassedHook(DeciTreeOption<CompnapInfo> option) {
		List<ActionStd<CompnapInfo>> actions = new ArrayList<>();
		
		ActionStd<CompnapInfo> select = new StdCompnapMergeToSelect(option);	
		actions.add(select);
		
		return actions;
	}
}
