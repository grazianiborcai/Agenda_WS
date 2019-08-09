package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.business.masterData.model.action.StdPositionSelect;
import br.com.gda.business.masterData.model.checker.PositionCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootPositionSelect extends DeciTreeReadTemplate<PositionInfo> {
	
	public RootPositionSelect(DeciTreeOption<PositionInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PositionInfo> buildDecisionCheckerHook(DeciTreeOption<PositionInfo> option) {
		List<ModelChecker<PositionInfo>> queue = new ArrayList<>();		
		ModelChecker<PositionInfo> checker;
		
		checker = new PositionCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PositionInfo>> buildActionsOnPassedHook(DeciTreeOption<PositionInfo> option) {
		List<ActionStd<PositionInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPositionSelect(option));
		return actions;
	}
}
