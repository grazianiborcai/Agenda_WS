package br.com.gda.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.model.action.LazyUpswdEnforceHash;
import br.com.gda.security.userPassword.model.action.LazyUpswdEnforceLength;
import br.com.gda.security.userPassword.model.action.LazyUpswdEnforceSalt;
import br.com.gda.security.userPassword.model.action.LazyUpswdInsert;
import br.com.gda.security.userPassword.model.action.LazyUpswdSendEmail;
import br.com.gda.security.userPassword.model.action.LazyUpswdSuccess;
import br.com.gda.security.userPassword.model.action.StdUpswdEnforceLChanged;
import br.com.gda.security.userPassword.model.checker.UpswdCheckExist;
import br.com.gda.security.userPassword.model.checker.UpswdCheckOwner;
import br.com.gda.security.userPassword.model.checker.UpswdCheckUser;
import br.com.gda.security.userPassword.model.checker.UpswdCheckWrite;

public final class RootUpswdInsert extends DeciTreeWriteTemplate<UpswdInfo> {
	
	public RootUpswdInsert(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildDecisionCheckerHook(DeciTreeOption<UpswdInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new UpswdCheckWrite();
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
		
		ActionStd<UpswdInfo> enforceLChanged = new StdUpswdEnforceLChanged(option);
		ActionLazy<UpswdInfo> enforceLength = new LazyUpswdEnforceLength(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> enforceSalt = new LazyUpswdEnforceSalt(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> enforceHash = new LazyUpswdEnforceHash(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> insert = new LazyUpswdInsert(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> sendEmail = new LazyUpswdSendEmail(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> success = new LazyUpswdSuccess(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLength);
		enforceLength.addPostAction(enforceSalt);
		enforceSalt.addPostAction(enforceHash);				
		enforceHash.addPostAction(insert);
		insert.addPostAction(sendEmail);
		sendEmail.addPostAction(success);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
