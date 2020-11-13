package br.com.mind5.masterData.authorizationGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;
import br.com.mind5.masterData.authorizationGroup.model.action.StdAuthgroupDaoSelect;
import br.com.mind5.masterData.authorizationGroup.model.checker.AuthgroupCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootAuthgroupSelect extends DeciTreeTemplateRead<AuthgroupInfo> {
	
	public RootAuthgroupSelect(DeciTreeOption<AuthgroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AuthgroupInfo> buildCheckerHook(DeciTreeOption<AuthgroupInfo> option) {
		List<ModelChecker<AuthgroupInfo>> queue = new ArrayList<>();		
		ModelChecker<AuthgroupInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AuthgroupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AuthgroupInfo>> buildActionsOnPassedHook(DeciTreeOption<AuthgroupInfo> option) {
		List<ActionStd<AuthgroupInfo>> actions = new ArrayList<>();
		
		ActionStd<AuthgroupInfo> select = new StdAuthgroupDaoSelect(option);
		
		actions.add(select);		
		return actions;
	}
}
