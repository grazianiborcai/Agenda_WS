package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.business.masterData.model.action.StdAuthGrRoleSelect;
import br.com.mind5.business.masterData.model.checker.AuthGrRoleCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootAuthGrRoleSelect extends DeciTreeTemplateReadV1<AuthGrRoleInfo> {
	
	public RootAuthGrRoleSelect(DeciTreeOption<AuthGrRoleInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AuthGrRoleInfo> buildCheckerHook(DeciTreeOption<AuthGrRoleInfo> option) {
		List<ModelCheckerV1<AuthGrRoleInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AuthGrRoleInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AuthGrRoleCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AuthGrRoleInfo>> buildActionsOnPassedHook(DeciTreeOption<AuthGrRoleInfo> option) {
		List<ActionStdV1<AuthGrRoleInfo>> actions = new ArrayList<>();
		
		ActionStdV1<AuthGrRoleInfo> select = new StdAuthGrRoleSelect(option);
		
		actions.add(select);		
		return actions;
	}
}
