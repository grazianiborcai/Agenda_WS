package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.business.masterData.model.action.StdPositionSelect;
import br.com.mind5.business.masterData.model.checker.PositionCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
