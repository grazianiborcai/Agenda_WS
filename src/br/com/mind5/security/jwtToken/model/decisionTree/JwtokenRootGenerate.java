package br.com.mind5.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.action.JwtokenVisiEnforceAlgo;
import br.com.mind5.security.jwtToken.model.action.JwtokenVisiEnforceCreatedOn;
import br.com.mind5.security.jwtToken.model.action.JwtokenVisiEnforceExpiration;
import br.com.mind5.security.jwtToken.model.action.JwtokenVisiEnforceSecret;
import br.com.mind5.security.jwtToken.model.action.JwtokenVisiEnforceToken;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckGenerate;

public final class JwtokenRootGenerate extends DeciTreeTemplateWrite<JwtokenInfo> {
	
	public JwtokenRootGenerate(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<JwtokenInfo> buildCheckerHook(DeciTreeOption<JwtokenInfo> option) {
		List<ModelChecker<JwtokenInfo>> queue = new ArrayList<>();		
		ModelChecker<JwtokenInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new JwtokenCheckGenerate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStd<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStd<JwtokenInfo> nodePlatform = new  JwtokenNodePlatform(option).toAction();
		ActionLazy<JwtokenInfo> enforceCreatedOn = new ActionLazyCommom<JwtokenInfo>(option, JwtokenVisiEnforceCreatedOn.class);
		ActionLazy<JwtokenInfo> enforceSecret = new ActionLazyCommom<JwtokenInfo>(option, JwtokenVisiEnforceSecret.class);
		ActionLazy<JwtokenInfo> enforceExpiration = new ActionLazyCommom<JwtokenInfo>(option, JwtokenVisiEnforceExpiration.class);
		ActionLazy<JwtokenInfo> enforceAlgo = new ActionLazyCommom<JwtokenInfo>(option, JwtokenVisiEnforceAlgo.class);
		ActionLazy<JwtokenInfo> enforceToken = new ActionLazyCommom<JwtokenInfo>(option, JwtokenVisiEnforceToken.class);
		
		nodePlatform.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceSecret);
		enforceSecret.addPostAction(enforceExpiration);
		enforceExpiration.addPostAction(enforceAlgo);
		enforceAlgo.addPostAction(enforceToken);
		
		actions.add(nodePlatform);
		return actions;
	}
}
