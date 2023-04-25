package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.UpswdVisiDaoInsert;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceHash;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceLChanged;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceLength;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceSalt;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckExist;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckOwner;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckUser;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckWrite;

public final class UpswdRootInsertSilent extends DeciTreeTemplateWrite<UpswdInfo> {
	
	public UpswdRootInsertSilent(DeciTreeOption<UpswdInfo> option) {
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
		checker = new UpswdCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UpswdCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UpswdCheckUser(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new UpswdCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd <UpswdInfo> enforceLChanged = new ActionStdCommom <UpswdInfo>(option, UpswdVisiEnforceLChanged.class);
		ActionLazy<UpswdInfo> enforceLength   = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiEnforceLength.class);
		ActionLazy<UpswdInfo> enforceSalt     = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiEnforceSalt.class);
		ActionLazy<UpswdInfo> enforceHash     = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiEnforceHash.class);
		ActionLazy<UpswdInfo> insert          = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(enforceLength);
		enforceLength.addPostAction(enforceSalt);
		enforceSalt.addPostAction(enforceHash);				
		enforceHash.addPostAction(insert);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
