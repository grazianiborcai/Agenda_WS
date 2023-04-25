package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforcePasswordRandom;
import br.com.mind5.security.userPassword.model.action.UpswdVisiRootInsert;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckWriteRandom;

public final class UpswdRootInsertRandom extends DeciTreeTemplateWrite<UpswdInfo> {
	
	public UpswdRootInsertRandom(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UpswdCheckWriteRandom(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd <UpswdInfo> enforcePassword = new ActionStdCommom <UpswdInfo>(option, UpswdVisiEnforcePasswordRandom.class);
		ActionLazy<UpswdInfo> insert          = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiRootInsert.class);
		ActionStd <UpswdInfo> success         = new ActionStdSuccessCommom<UpswdInfo>(option);
		
		enforcePassword.addPostAction(insert);
		
		actions.add(enforcePassword);
		actions.add(success);
		
		return actions;
	}
}
