package br.com.mind5.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.action.UselisVisiMergePersolis;
import br.com.mind5.security.userList.model.checker.UselisCheckHasPerson;

public final class UselisNodePerson extends DeciTreeTemplateRead<UselisInfo> {
	
	public UselisNodePerson(DeciTreeOption<UselisInfo> option) {
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
		
		ActionStd<UselisInfo> mergePersolis = new ActionStdCommom<UselisInfo>(option, UselisVisiMergePersolis.class);
		
		actions.add(mergePersolis);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<UselisInfo>> buildActionsOnFailedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStd<UselisInfo>> actions = new ArrayList<>();
		
		ActionStd<UselisInfo> success = new ActionStdSuccessCommom<UselisInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
