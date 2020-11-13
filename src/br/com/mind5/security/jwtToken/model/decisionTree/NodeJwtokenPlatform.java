package br.com.mind5.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.action.StdJwtokenEnforcePlatform;
import br.com.mind5.security.jwtToken.model.action.StdJwtokenSuccess;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckHasPlatform;

public final class NodeJwtokenPlatform extends DeciTreeTemplateWrite<JwtokenInfo> {
	
	public NodeJwtokenPlatform(DeciTreeOption<JwtokenInfo> option) {
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
		checker = new JwtokenCheckHasPlatform(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStd<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStd<JwtokenInfo> success = new StdJwtokenSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<JwtokenInfo>> buildActionsOnFailedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStd<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStd<JwtokenInfo> enforcePlatform = new StdJwtokenEnforcePlatform(option);
		
		actions.add(enforcePlatform);
		return actions;
	}
}
