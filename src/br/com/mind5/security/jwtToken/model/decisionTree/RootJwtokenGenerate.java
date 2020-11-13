package br.com.mind5.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceAlgo;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceCreatedOn;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceExpiration;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceSecret;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceToken;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckGenerate;

public final class RootJwtokenGenerate extends DeciTreeTemplateWrite<JwtokenInfo> {
	
	public RootJwtokenGenerate(DeciTreeOption<JwtokenInfo> option) {
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
		
		ActionStd<JwtokenInfo> nodePlatform = new  NodeJwtokenPlatform(option).toAction();
		ActionLazy<JwtokenInfo> enforceCreatedOn = new LazyJwtokenEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<JwtokenInfo> enforceSecret = new LazyJwtokenEnforceSecret(option.conn, option.schemaName);
		ActionLazy<JwtokenInfo> enforceExpiration = new LazyJwtokenEnforceExpiration(option.conn, option.schemaName);
		ActionLazy<JwtokenInfo> enforceAlgo = new LazyJwtokenEnforceAlgo(option.conn, option.schemaName);
		ActionLazy<JwtokenInfo> enforceToken = new LazyJwtokenEnforceToken(option.conn, option.schemaName);
		
		nodePlatform.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceSecret);
		enforceSecret.addPostAction(enforceExpiration);
		enforceExpiration.addPostAction(enforceAlgo);
		enforceAlgo.addPostAction(enforceToken);
		
		actions.add(nodePlatform);
		return actions;
	}
}
