package br.com.mind5.masterData.authorizationGroupRole.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.masterData.authorizationGroupRole.model.action.AuthgroleVisiDaoSelect;
import br.com.mind5.masterData.authorizationGroupRole.model.checker.AuthgroleCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class AuthgroleRootSelect extends DeciTreeTemplateRead<AuthgroleInfo> {
	
	public AuthgroleRootSelect(DeciTreeOption<AuthgroleInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AuthgroleInfo> buildCheckerHook(DeciTreeOption<AuthgroleInfo> option) {
		List<ModelChecker<AuthgroleInfo>> queue = new ArrayList<>();		
		ModelChecker<AuthgroleInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AuthgroleCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AuthgroleInfo>> buildActionsOnPassedHook(DeciTreeOption<AuthgroleInfo> option) {
		List<ActionStd<AuthgroleInfo>> actions = new ArrayList<>();
		
		ActionStd<AuthgroleInfo> select = new ActionStdCommom<AuthgroleInfo>(option, AuthgroleVisiDaoSelect.class);
		
		actions.add(select);		
		return actions;
	}
}
