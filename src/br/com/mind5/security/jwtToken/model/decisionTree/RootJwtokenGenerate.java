package br.com.mind5.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceAlgo;
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
	
	
	
	@Override protected List<ActionStdV1<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStdV1<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStdV1<JwtokenInfo> nodePlatform = new  NodeJwtokenPlatform(option).toAction();
		ActionLazyV1<JwtokenInfo> enforceSecret = new LazyJwtokenEnforceSecret(option.conn, option.schemaName);
		ActionLazyV1<JwtokenInfo> enforceExpiration = new LazyJwtokenEnforceExpiration(option.conn, option.schemaName);
		ActionLazyV1<JwtokenInfo> enforceAlgo = new LazyJwtokenEnforceAlgo(option.conn, option.schemaName);
		ActionLazyV1<JwtokenInfo> enforceToken = new LazyJwtokenEnforceToken(option.conn, option.schemaName);
		
		nodePlatform.addPostAction(enforceSecret);
		enforceSecret.addPostAction(enforceExpiration);
		enforceExpiration.addPostAction(enforceAlgo);
		enforceAlgo.addPostAction(enforceToken);
		
		actions.add(nodePlatform);
		return actions;
	}
}
