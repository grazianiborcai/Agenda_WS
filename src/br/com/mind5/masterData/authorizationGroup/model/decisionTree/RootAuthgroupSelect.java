package br.com.mind5.masterData.authorizationGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;
import br.com.mind5.masterData.authorizationGroup.model.action.StdAuthgroupDaoSelect;
import br.com.mind5.masterData.authorizationGroup.model.checker.AuthgroupCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootAuthgroupSelect extends DeciTreeTemplateReadV1<AuthgroupInfo> {
	
	public RootAuthgroupSelect(DeciTreeOption<AuthgroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AuthgroupInfo> buildCheckerHook(DeciTreeOption<AuthgroupInfo> option) {
		List<ModelCheckerV1<AuthgroupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AuthgroupInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AuthgroupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AuthgroupInfo>> buildActionsOnPassedHook(DeciTreeOption<AuthgroupInfo> option) {
		List<ActionStdV1<AuthgroupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<AuthgroupInfo> select = new StdAuthgroupDaoSelect(option);
		
		actions.add(select);		
		return actions;
	}
}
