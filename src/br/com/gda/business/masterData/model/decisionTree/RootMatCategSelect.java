package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.model.action.StdMatCategSelect;
import br.com.gda.business.masterData.model.checker.MatCategCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatCategSelect extends DeciTreeReadTemplate<MatCategInfo> {
	
	public RootMatCategSelect(DeciTreeOption<MatCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatCategInfo> buildDecisionCheckerHook(DeciTreeOption<MatCategInfo> option) {
		List<ModelChecker<MatCategInfo>> queue = new ArrayList<>();		
		ModelChecker<MatCategInfo> checker;
		
		checker = new MatCategCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatCategInfo>> buildActionsOnPassedHook(DeciTreeOption<MatCategInfo> option) {
		List<ActionStd<MatCategInfo>> actions = new ArrayList<>();
		
		actions.add(new StdMatCategSelect(option));
		return actions;
	}
}
