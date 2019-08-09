package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.model.action.StdMatGroupSelect;
import br.com.gda.business.masterData.model.checker.MatGroupCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatGroupSelect extends DeciTreeReadTemplate<MatGroupInfo> {
	
	public RootMatGroupSelect(DeciTreeOption<MatGroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatGroupInfo> buildDecisionCheckerHook(DeciTreeOption<MatGroupInfo> option) {
		List<ModelChecker<MatGroupInfo>> queue = new ArrayList<>();		
		ModelChecker<MatGroupInfo> checker;
		
		checker = new MatGroupCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatGroupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatGroupInfo> option) {
		List<ActionStd<MatGroupInfo>> actions = new ArrayList<>();
		
		actions.add(new StdMatGroupSelect(option));
		return actions;
	}
}
