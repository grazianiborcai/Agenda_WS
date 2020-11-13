package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdRootInsertSilent;
import br.com.mind5.security.userPassword.model.action.LazyUpswdSuccess;
import br.com.mind5.security.userPassword.model.action.StdUpswdEnforcePasswordAnonymous;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckWriteAnonymous;

public final class RootUpswdInsertAnonymous extends DeciTreeTemplateWrite<UpswdInfo> {
	
	public RootUpswdInsertAnonymous(DeciTreeOption<UpswdInfo> option) {
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
		checker = new UpswdCheckWriteAnonymous(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd<UpswdInfo> enforcePassword = new StdUpswdEnforcePasswordAnonymous(option);
		ActionLazy<UpswdInfo> insert = new LazyUpswdRootInsertSilent(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> success = new LazyUpswdSuccess(option.conn, option.schemaName);
		
		enforcePassword.addPostAction(insert);
		insert.addPostAction(success);
		
		actions.add(enforcePassword);	
		return actions;
	}
}
