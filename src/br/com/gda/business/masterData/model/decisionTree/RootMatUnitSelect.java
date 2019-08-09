package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.action.StdMatUnitSelect;
import br.com.gda.business.masterData.model.checker.MatUnitCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatUnitSelect extends DeciTreeReadTemplate<MatUnitInfo> {
	
	public RootMatUnitSelect(DeciTreeOption<MatUnitInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatUnitInfo> buildDecisionCheckerHook(DeciTreeOption<MatUnitInfo> option) {
		List<ModelChecker<MatUnitInfo>> queue = new ArrayList<>();		
		ModelChecker<MatUnitInfo> checker;
		
		checker = new MatUnitCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatUnitInfo>> buildActionsOnPassedHook(DeciTreeOption<MatUnitInfo> option) {
		List<ActionStd<MatUnitInfo>> actions = new ArrayList<>();
		
		actions.add(new StdMatUnitSelect(option));
		return actions;
	}
}
