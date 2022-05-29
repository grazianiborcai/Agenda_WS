package br.com.mind5.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.action.JwtokenVisiNodeValidateL1;
import br.com.mind5.security.jwtToken.model.action.JwtokenVisiEnforceAlgo;
import br.com.mind5.security.jwtToken.model.action.JwtokenVisiEnforceSecret;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckValidate;

public final class JwtokenRootValidate extends DeciTreeTemplateWrite<JwtokenInfo> {
	
	public JwtokenRootValidate(DeciTreeOption<JwtokenInfo> option) {
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
		
		ActionStd<JwtokenInfo> enforceSecret = new ActionStdCommom<JwtokenInfo>(option, JwtokenVisiEnforceSecret.class);
		ActionLazy<JwtokenInfo> enforceAlgo = new ActionLazyCommom<JwtokenInfo>(option, JwtokenVisiEnforceAlgo.class);
		ActionLazy<JwtokenInfo> nodeL1 = new ActionLazyCommom<JwtokenInfo>(option, JwtokenVisiNodeValidateL1.class);
		
		enforceSecret.addPostAction(enforceAlgo);
		enforceAlgo.addPostAction(nodeL1);
		
		actions.add(enforceSecret);
		return actions;
	}
}
