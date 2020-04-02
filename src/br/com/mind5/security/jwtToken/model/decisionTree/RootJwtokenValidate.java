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
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenNodeValidate;
import br.com.mind5.security.jwtToken.model.action.StdJwtokenEnforceSecret;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckValidate;

public final class RootJwtokenValidate extends DeciTreeWriteTemplate<JwtokenInfo> {
	
	public RootJwtokenValidate(DeciTreeOption<JwtokenInfo> option) {
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
		checker = new JwtokenCheckValidate(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStdV1<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStdV1<JwtokenInfo> enforceSecret = new StdJwtokenEnforceSecret(option);
		ActionLazyV1<JwtokenInfo> enforceAlgo = new LazyJwtokenEnforceAlgo(option.conn, option.schemaName);
		ActionLazyV1<JwtokenInfo> validate = new LazyJwtokenNodeValidate(option.conn, option.schemaName);
		
		enforceSecret.addPostAction(enforceAlgo);
		enforceAlgo.addPostAction(validate);
		
		actions.add(enforceSecret);
		return actions;
	}
}
