package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.UserCategInfo;
import br.com.gda.business.masterData.model.action.StdUserCategSelect;
import br.com.gda.business.masterData.model.checker.UserCategCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootUserCategSelect extends DeciTreeReadTemplate<UserCategInfo> {
	
	public RootUserCategSelect(DeciTreeOption<UserCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserCategInfo> buildDecisionCheckerHook(DeciTreeOption<UserCategInfo> option) {
		List<ModelChecker<UserCategInfo>> queue = new ArrayList<>();		
		ModelChecker<UserCategInfo> checker;
		
		checker = new UserCategCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserCategInfo>> buildActionsOnPassedHook(DeciTreeOption<UserCategInfo> option) {
		List<ActionStd<UserCategInfo>> actions = new ArrayList<>();
		
		actions.add(new StdUserCategSelect(option));
		return actions;
	}
}
