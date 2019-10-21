package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.masterData.model.action.StdGenderSelect;
import br.com.mind5.business.masterData.model.checker.GenderCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootGenderSelect extends DeciTreeReadTemplate<GenderInfo> {
	
	public RootGenderSelect(DeciTreeOption<GenderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<GenderInfo> buildDecisionCheckerHook(DeciTreeOption<GenderInfo> option) {
		List<ModelChecker<GenderInfo>> queue = new ArrayList<>();		
		ModelChecker<GenderInfo> checker;
		
		checker = new GenderCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<GenderInfo>> buildActionsOnPassedHook(DeciTreeOption<GenderInfo> option) {
		List<ActionStd<GenderInfo>> actions = new ArrayList<>();
		
		actions.add(new StdGenderSelect(option));
		return actions;
	}
}
