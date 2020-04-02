package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.business.masterData.model.action.StdAuthGrRoleSelect;
import br.com.mind5.business.masterData.model.checker.AuthGrRoleCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootAuthGrRoleSelect extends DeciTreeReadTemplate<AuthGrRoleInfo> {
	
	public RootAuthGrRoleSelect(DeciTreeOption<AuthGrRoleInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AuthGrRoleInfo> buildDecisionCheckerHook(DeciTreeOption<AuthGrRoleInfo> option) {
		List<ModelChecker<AuthGrRoleInfo>> queue = new ArrayList<>();		
		ModelChecker<AuthGrRoleInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AuthGrRoleCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AuthGrRoleInfo>> buildActionsOnPassedHook(DeciTreeOption<AuthGrRoleInfo> option) {
		List<ActionStdV1<AuthGrRoleInfo>> actions = new ArrayList<>();
		
		ActionStdV1<AuthGrRoleInfo> select = new StdAuthGrRoleSelect(option);
		
		actions.add(select);		
		return actions;
	}
}
