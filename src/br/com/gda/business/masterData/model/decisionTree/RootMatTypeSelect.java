package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.action.StdMatTypeSelect;
import br.com.gda.business.masterData.model.checker.MatTypeCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatTypeSelect extends DeciTreeReadTemplate<MatTypeInfo> {
	
	public RootMatTypeSelect(DeciTreeOption<MatTypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatTypeInfo> buildDecisionCheckerHook(DeciTreeOption<MatTypeInfo> option) {
		List<ModelChecker<MatTypeInfo>> queue = new ArrayList<>();		
		ModelChecker<MatTypeInfo> checker;
		
		checker = new MatTypeCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatTypeInfo>> buildActionsOnPassedHook(DeciTreeOption<MatTypeInfo> option) {
		List<ActionStd<MatTypeInfo>> actions = new ArrayList<>();
		
		actions.add(new StdMatTypeSelect(option));
		return actions;
	}
}
