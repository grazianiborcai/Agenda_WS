package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGroupInfo;
import br.com.mind5.business.masterData.model.action.StdAuthGroupSelect;
import br.com.mind5.business.masterData.model.checker.AuthGroupCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootAuthGroupSelect extends DeciTreeTemplateReadV1<AuthGroupInfo> {
	
	public RootAuthGroupSelect(DeciTreeOption<AuthGroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AuthGroupInfo> buildCheckerHook(DeciTreeOption<AuthGroupInfo> option) {
		List<ModelCheckerV1<AuthGroupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AuthGroupInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AuthGroupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AuthGroupInfo>> buildActionsOnPassedHook(DeciTreeOption<AuthGroupInfo> option) {
		List<ActionStdV1<AuthGroupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<AuthGroupInfo> select = new StdAuthGroupSelect(option);
		
		actions.add(select);		
		return actions;
	}
}
