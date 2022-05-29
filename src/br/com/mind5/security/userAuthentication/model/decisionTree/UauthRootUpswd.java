package br.com.mind5.security.userAuthentication.model.decisionTree;

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
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userAuthentication.model.action.UauthVisiAuthenticateUpswd;
import br.com.mind5.security.userAuthentication.model.action.UauthVisiMergeUselis;
import br.com.mind5.security.userAuthentication.model.checker.UauthCheckRead;

public final class UauthRootUpswd extends DeciTreeTemplateWrite<UauthInfo> {
	
	public UauthRootUpswd(DeciTreeOption<UauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UauthInfo> buildCheckerHook(DeciTreeOption<UauthInfo> option) {
		List<ModelChecker<UauthInfo>> queue = new ArrayList<>();		
		ModelChecker<UauthInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UauthCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UauthInfo>> buildActionsOnPassedHook(DeciTreeOption<UauthInfo> option) {
		List<ActionStd<UauthInfo>> actions = new ArrayList<>();
		
		ActionStd<UauthInfo> authenticateUpswd = new ActionStdCommom<UauthInfo>(option, UauthVisiAuthenticateUpswd.class);
		ActionLazy<UauthInfo> mergeUselis = new ActionLazyCommom<UauthInfo>(option, UauthVisiMergeUselis.class);
		
		authenticateUpswd.addPostAction(mergeUselis);
		
		actions.add(authenticateUpswd);		
		return actions;
	}
}
