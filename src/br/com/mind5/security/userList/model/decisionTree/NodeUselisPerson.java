package br.com.mind5.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.action.StdUselisMergePersolis;
import br.com.mind5.security.userList.model.action.StdUselisSuccess;
import br.com.mind5.security.userList.model.checker.UselisCheckHasPerson;

public final class NodeUselisPerson extends DeciTreeTemplateRead<UselisInfo> {
	
	public NodeUselisPerson(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UselisInfo> buildCheckerHook(DeciTreeOption<UselisInfo> option) {
		List<ModelChecker<UselisInfo>> queue = new ArrayList<>();		
		ModelChecker<UselisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UselisCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UselisInfo>> buildActionsOnPassedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStd<UselisInfo>> actions = new ArrayList<>();
		
		ActionStd<UselisInfo> mergePersolis = new StdUselisMergePersolis(option);
		
		actions.add(mergePersolis);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<UselisInfo>> buildActionsOnFailedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStd<UselisInfo>> actions = new ArrayList<>();
		
		ActionStd<UselisInfo> success = new StdUselisSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
