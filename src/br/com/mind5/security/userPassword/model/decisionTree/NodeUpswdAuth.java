package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceHashToMatch;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceLength;
import br.com.mind5.security.userPassword.model.action.LazyUpswdNodeMatch;
import br.com.mind5.security.userPassword.model.action.StdUpswdMergeToAuth;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckExist;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckIsPasswordEnabled;

public final class NodeUpswdAuth extends DeciTreeReadTemplate<UpswdInfo> {
	
	public NodeUpswdAuth(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildDecisionCheckerHook(DeciTreeOption<UpswdInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStdV1<UpswdInfo>> actions = new ArrayList<>();

		ActionStdV1<UpswdInfo> mergeToAuth = new StdUpswdMergeToAuth(option);
		ActionLazyV1<UpswdInfo> enforceLength = new LazyUpswdEnforceLength(option.conn, option.schemaName);
		ActionLazyV1<UpswdInfo> enforceHashToMatch = new LazyUpswdEnforceHashToMatch(option.conn, option.schemaName);		
		ActionLazyV1<UpswdInfo> nodeMatch = new LazyUpswdNodeMatch(option.conn, option.schemaName);
		
		mergeToAuth.addPostAction(enforceLength);		
		enforceLength.addPostAction(enforceHashToMatch);
		enforceHashToMatch.addPostAction(nodeMatch);
		
		actions.add(mergeToAuth);		
		return actions;
	}
}
