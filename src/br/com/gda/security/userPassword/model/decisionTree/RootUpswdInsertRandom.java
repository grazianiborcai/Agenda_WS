package br.com.gda.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.model.action.LazyUpswdMergeUser;
import br.com.gda.security.userPassword.model.action.LazyUpswdNodeEmail;
import br.com.gda.security.userPassword.model.action.LazyUpswdRootInsert;
import br.com.gda.security.userPassword.model.action.StdUpswdEnforcePasswordRandom;
import br.com.gda.security.userPassword.model.checker.UpswdCheckExist;
import br.com.gda.security.userPassword.model.checker.UpswdCheckOwner;
import br.com.gda.security.userPassword.model.checker.UpswdCheckUser;
import br.com.gda.security.userPassword.model.checker.UpswdCheckWriteRandom;

public final class RootUpswdInsertRandom extends DeciTreeReadTemplate<UpswdInfo> {
	
	public RootUpswdInsertRandom(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildDecisionCheckerHook(DeciTreeOption<UpswdInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new UpswdCheckWriteRandom();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UpswdCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UpswdCheckUser(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;		
		checker = new UpswdCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd<UpswdInfo> enforceRandom = new StdUpswdEnforcePasswordRandom(option);
		ActionLazy<UpswdInfo> insert = new LazyUpswdRootInsert(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> mergeUser = new LazyUpswdMergeUser(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> sendEmail = new LazyUpswdNodeEmail(option.conn, option.schemaName);
		
		enforceRandom.addPostAction(insert);
		enforceRandom.addPostAction(mergeUser);
		mergeUser.addPostAction(sendEmail);
		
		actions.add(enforceRandom);	
		return actions;
	}
}
