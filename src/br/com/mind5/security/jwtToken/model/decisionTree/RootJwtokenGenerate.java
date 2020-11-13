package br.com.mind5.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceAlgo;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceCreatedOn;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceExpiration;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceSecret;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceToken;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckGenerate;

public final class RootJwtokenGenerate extends DeciTreeTemplateWriteV2<JwtokenInfo> {
	
	public RootJwtokenGenerate(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<JwtokenInfo> buildCheckerHook(DeciTreeOption<JwtokenInfo> option) {
		List<ModelCheckerV1<JwtokenInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<JwtokenInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new JwtokenCheckGenerate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStdV2<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStdV2<JwtokenInfo> nodePlatform = new  NodeJwtokenPlatform(option).toAction();
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
