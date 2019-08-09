package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.model.action.StdGenderSelect;
import br.com.gda.business.masterData.model.checker.GenderCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
