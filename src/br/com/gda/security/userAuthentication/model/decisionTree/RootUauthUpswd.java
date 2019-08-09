package br.com.gda.security.userAuthentication.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.userAuthentication.info.UauthInfo;
import br.com.gda.security.userAuthentication.model.action.LazyUauthAuthenticateUpswd;
import br.com.gda.security.userAuthentication.model.action.LazyUauthMergeUser;
import br.com.gda.security.userAuthentication.model.action.StdUauthEnforceCodUser;
import br.com.gda.security.userAuthentication.model.checker.UauthCheckRead;

public final class RootUauthUpswd extends DeciTreeWriteTemplate<UauthInfo> {
	
	public RootUauthUpswd(DeciTreeOption<UauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UauthInfo> buildDecisionCheckerHook(DeciTreeOption<UauthInfo> option) {
		List<ModelChecker<UauthInfo>> queue = new ArrayList<>();		
		ModelChecker<UauthInfo> checker;
		
		checker = new UauthCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UauthInfo>> buildActionsOnPassedHook(DeciTreeOption<UauthInfo> option) {
		List<ActionStd<UauthInfo>> actions = new ArrayList<>();
		
		ActionStd<UauthInfo> enforceCodUser = new StdUauthEnforceCodUser(option);
		ActionLazy<UauthInfo> authenticateUpswd = new LazyUauthAuthenticateUpswd(option.conn, option.schemaName);
		ActionLazy<UauthInfo> mergeUser = new LazyUauthMergeUser(option.conn, option.schemaName);
		
		enforceCodUser.addPostAction(authenticateUpswd);	
		enforceCodUser.addPostAction(mergeUser);
		
		actions.add(enforceCodUser);		
		return actions;
	}
}
