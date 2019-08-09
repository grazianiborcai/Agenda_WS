package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.business.masterData.model.action.StdAuthGrRoleSelect;
import br.com.gda.business.masterData.model.checker.AuthGrRoleCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootAuthGrRoleSelect extends DeciTreeReadTemplate<AuthGrRoleInfo> {
	
	public RootAuthGrRoleSelect(DeciTreeOption<AuthGrRoleInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AuthGrRoleInfo> buildDecisionCheckerHook(DeciTreeOption<AuthGrRoleInfo> option) {
		List<ModelChecker<AuthGrRoleInfo>> queue = new ArrayList<>();		
		ModelChecker<AuthGrRoleInfo> checker;
		
		checker = new AuthGrRoleCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AuthGrRoleInfo>> buildActionsOnPassedHook(DeciTreeOption<AuthGrRoleInfo> option) {
		List<ActionStd<AuthGrRoleInfo>> actions = new ArrayList<>();
		
		ActionStd<AuthGrRoleInfo> select = new StdAuthGrRoleSelect(option);
		
		actions.add(select);		
		return actions;
	}
}
