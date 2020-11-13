package br.com.mind5.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenEnforceAlgo;
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenParse;
import br.com.mind5.security.jwtToken.model.action.StdJwtokenEnforceSecret;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckValidate;

public final class RootJwtokenParse extends DeciTreeTemplateWrite<JwtokenInfo> {
	
	public RootJwtokenParse(DeciTreeOption<JwtokenInfo> option) {
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
		checker = new JwtokenCheckValidate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}		
	
	
	
	@Override protected List<ActionStd<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStd<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStd<JwtokenInfo> enforceSecret = new StdJwtokenEnforceSecret(option);
		ActionLazy<JwtokenInfo> enforceAlgo = new LazyJwtokenEnforceAlgo(option.conn, option.schemaName);
		ActionLazy<JwtokenInfo> parse = new LazyJwtokenParse(option.conn, option.schemaName);
		
		enforceSecret.addPostAction(enforceAlgo);
		enforceAlgo.addPostAction(parse);
		
		actions.add(enforceSecret);
		return actions;
	}
}
