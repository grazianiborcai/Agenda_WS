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
import br.com.gda.security.jwtToken.model.action.LazyJwtokenParse;
import br.com.gda.security.jwtToken.model.action.StdJwtokenEnforceSecret;
import br.com.gda.security.jwtToken.model.checker.JwtokenCheckValidate;

public final class RootJwtokenParse extends DeciTreeWriteTemplate<JwtokenInfo> {
	
	public RootJwtokenParse(DeciTreeOption<JwtokenInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<JwtokenInfo> buildDecisionCheckerHook(DeciTreeOption<JwtokenInfo> option) {
		List<ModelChecker<JwtokenInfo>> queue = new ArrayList<>();		
		ModelChecker<JwtokenInfo> checker;
		
		checker = new JwtokenCheckValidate();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
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
