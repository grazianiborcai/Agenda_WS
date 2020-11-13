package br.com.mind5.security.jwtToken.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.action.StdJwtokenEnforcePlatform;
import br.com.mind5.security.jwtToken.model.action.StdJwtokenSuccess;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckHasPlatform;

public final class NodeJwtokenPlatform extends DeciTreeTemplateWriteV2<JwtokenInfo> {
	
	public NodeJwtokenPlatform(DeciTreeOption<JwtokenInfo> option) {
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
		checker = new JwtokenCheckHasPlatform(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStdV2<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStdV2<JwtokenInfo> success = new StdJwtokenSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<JwtokenInfo>> buildActionsOnFailedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStdV2<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStdV2<JwtokenInfo> enforcePlatform = new StdJwtokenEnforcePlatform(option);
		
		actions.add(enforcePlatform);
		return actions;
	}
}
