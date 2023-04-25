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
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceHashToMatch;
import br.com.mind5.security.userPassword.model.action.UpswdVisiEnforceLength;
import br.com.mind5.security.userPassword.model.action.UpswdVisiMergeToAuth;
import br.com.mind5.security.userPassword.model.action.UpswdVisiNodeMatch;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckExist;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckIsPasswordEnabled;

public final class UpswdNodeAuth extends DeciTreeTemplateWrite<UpswdInfo> {
	
	public UpswdNodeAuth(DeciTreeOption<UpswdInfo> option) {
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
		checker = new UpswdCheckIsPasswordEnabled(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UpswdCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();

		ActionStd <UpswdInfo> mergeToAuth        = new ActionStdCommom <UpswdInfo>(option, UpswdVisiMergeToAuth.class);
		ActionLazy<UpswdInfo> enforceLength      = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiEnforceLength.class);
		ActionLazy<UpswdInfo> enforceHashToMatch = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiEnforceHashToMatch.class);		
		ActionLazy<UpswdInfo> nodeMatch          = new ActionLazyCommom<UpswdInfo>(option, UpswdVisiNodeMatch.class);
		
		mergeToAuth.addPostAction(enforceLength);		
		enforceLength.addPostAction(enforceHashToMatch);
		enforceHashToMatch.addPostAction(nodeMatch);
		
		actions.add(mergeToAuth);		
		return actions;
	}
}
