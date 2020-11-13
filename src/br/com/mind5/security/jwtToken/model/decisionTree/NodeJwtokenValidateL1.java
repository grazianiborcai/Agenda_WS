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
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenNodeValidateL2;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckToken;

public final class NodeJwtokenValidateL1 extends DeciTreeTemplateWrite<JwtokenInfo> {
	
	public NodeJwtokenValidateL1(DeciTreeOption<JwtokenInfo> option) {
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
		checker = new JwtokenCheckToken(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStd<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStd<JwtokenInfo> parse = new RootJwtokenParse(option).toAction();
		ActionLazy<JwtokenInfo> nodeL2 = new LazyJwtokenNodeValidateL2(option.conn, option.schemaName);
		
		parse.addPostAction(nodeL2);
		
		actions.add(parse);
		return actions;
	}
}
