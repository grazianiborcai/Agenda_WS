package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdEnforceHashToMatch;
import br.com.mind5.security.userPassword.model.action.LazyUpswdNodeMatch;
import br.com.mind5.security.userPassword.model.action.StdUpswdKeepUpswd;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckAuth;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckExist;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckIsPasswordEnabled;

public final class RootUpswdAuth extends DeciTreeReadTemplate<UpswdInfo> {
	
	public RootUpswdAuth(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildDecisionCheckerHook(DeciTreeOption<UpswdInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new UpswdCheckAuth();
		queue.add(checker);
		
		checker = new UpswdCheckIsPasswordEnabled();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UpswdCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		//TODO: usuario de sistema nao pode ser autenticado. Adicionar check
		ActionStd<UpswdInfo> keepAttr = new StdUpswdKeepUpswd(option);
		ActionLazy<UpswdInfo> enforceHashToMatch = new LazyUpswdEnforceHashToMatch(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> nodeMatch = new LazyUpswdNodeMatch(option.conn, option.schemaName);
		
		keepAttr.addPostAction(enforceHashToMatch);		
		enforceHashToMatch.addPostAction(nodeMatch);
		
		actions.add(keepAttr);		
		return actions;
	}
}
