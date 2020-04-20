package br.com.mind5.masterData.authorizationGroupRole.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.masterData.authorizationGroupRole.model.action.StdAuthgroleDaoSelect;
import br.com.mind5.masterData.authorizationGroupRole.model.checker.AuthgroleCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootAuthgroleSelect extends DeciTreeTemplateReadV2<AuthgroleInfo> {
	
	public RootAuthgroleSelect(DeciTreeOption<AuthgroleInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AuthgroleInfo> buildCheckerHook(DeciTreeOption<AuthgroleInfo> option) {
		List<ModelCheckerV1<AuthgroleInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AuthgroleInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AuthgroleCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AuthgroleInfo>> buildActionsOnPassedHook(DeciTreeOption<AuthgroleInfo> option) {
		List<ActionStdV1<AuthgroleInfo>> actions = new ArrayList<>();
		
		ActionStdV1<AuthgroleInfo> select = new StdAuthgroleDaoSelect(option);
		
		actions.add(select);		
		return actions;
	}
}
