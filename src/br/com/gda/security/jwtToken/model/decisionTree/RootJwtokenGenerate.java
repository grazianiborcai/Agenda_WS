package br.com.gda.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.action.LazyJwtokenEnforceAlgo;
import br.com.gda.security.jwtToken.model.action.LazyJwtokenEnforceExpiration;
import br.com.gda.security.jwtToken.model.action.LazyJwtokenEnforceToken;
import br.com.gda.security.jwtToken.model.action.StdJwtokenEnforceSecret;
import br.com.gda.security.jwtToken.model.checker.JwtokenCheckGenerate;

public final class RootJwtokenGenerate extends DeciTreeWriteTemplate<JwtokenInfo> {
	
	public RootJwtokenGenerate(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<JwtokenInfo> buildDecisionCheckerHook(DeciTreeOption<JwtokenInfo> option) {
		List<ModelChecker<JwtokenInfo>> queue = new ArrayList<>();		
		ModelChecker<JwtokenInfo> checker;
		
		checker = new JwtokenCheckGenerate();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStd<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStd<JwtokenInfo> enforceSecret = new StdJwtokenEnforceSecret(option);
		ActionLazy<JwtokenInfo> enforceExpiration = new LazyJwtokenEnforceExpiration(option.conn, option.schemaName);
		ActionLazy<JwtokenInfo> enforceAlgo = new LazyJwtokenEnforceAlgo(option.conn, option.schemaName);
		ActionLazy<JwtokenInfo> enforceToken = new LazyJwtokenEnforceToken(option.conn, option.schemaName);
		
		enforceSecret.addPostAction(enforceExpiration);
		enforceExpiration.addPostAction(enforceAlgo);
		enforceAlgo.addPostAction(enforceToken);
		
		actions.add(enforceSecret);
		return actions;
	}
}
