package br.com.mind5.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceAlgo;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceExpiration;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceToken;
import br.com.mind5.security.jwtToken.model.action.StdJwtokenEnforceSecret;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckGenerate;

public final class RootJwtokenGenerate extends DeciTreeWriteTemplate<JwtokenInfo> {
	
	public RootJwtokenGenerate(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<JwtokenInfo> buildDecisionCheckerHook(DeciTreeOption<JwtokenInfo> option) {
		List<ModelChecker<JwtokenInfo>> queue = new ArrayList<>();		
		ModelChecker<JwtokenInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new JwtokenCheckGenerate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStdV1<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStdV1<JwtokenInfo> enforceSecret = new StdJwtokenEnforceSecret(option);
		ActionLazyV1<JwtokenInfo> enforceExpiration = new LazyJwtokenEnforceExpiration(option.conn, option.schemaName);
		ActionLazyV1<JwtokenInfo> enforceAlgo = new LazyJwtokenEnforceAlgo(option.conn, option.schemaName);
		ActionLazyV1<JwtokenInfo> enforceToken = new LazyJwtokenEnforceToken(option.conn, option.schemaName);
		
		enforceSecret.addPostAction(enforceExpiration);
		enforceExpiration.addPostAction(enforceAlgo);
		enforceAlgo.addPostAction(enforceToken);
		
		actions.add(enforceSecret);
		return actions;
	}
}
