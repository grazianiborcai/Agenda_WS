package br.com.mind5.masterData.authorizationGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;
import br.com.mind5.masterData.authorizationGroup.model.action.AuthgroupVisiDaoSelect;
import br.com.mind5.masterData.authorizationGroup.model.checker.AuthgroupCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class AuthgroupRootSelect extends DeciTreeTemplateRead<AuthgroupInfo> {
	
	public AuthgroupRootSelect(DeciTreeOption<AuthgroupInfo> option) {
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
		
		ActionStd<AuthgroupInfo> select = new ActionStdCommom<AuthgroupInfo>(option, AuthgroupVisiDaoSelect.class);
		
		actions.add(select);		
		return actions;
	}
}
