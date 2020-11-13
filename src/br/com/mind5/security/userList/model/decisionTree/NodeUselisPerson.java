package br.com.mind5.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.action.StdUselisMergePersolis;
import br.com.mind5.security.userList.model.action.StdUselisSuccess;
import br.com.mind5.security.userList.model.checker.UselisCheckHasPerson;

public final class NodeUselisPerson extends DeciTreeTemplateReadV2<UselisInfo> {
	
	public NodeUselisPerson(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UselisInfo> buildCheckerHook(DeciTreeOption<UselisInfo> option) {
		List<ModelCheckerV1<UselisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UselisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UselisCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<UselisInfo>> buildActionsOnPassedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStdV2<UselisInfo>> actions = new ArrayList<>();
		
		ActionStdV2<UselisInfo> mergePersolis = new StdUselisMergePersolis(option);
		
		actions.add(mergePersolis);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<UselisInfo>> buildActionsOnFailedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStdV2<UselisInfo>> actions = new ArrayList<>();
		
		ActionStdV2<UselisInfo> success = new StdUselisSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
