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
import br.com.mind5.security.jwtToken.model.action.LazyJwtokenNodeValidateL2;
import br.com.mind5.security.jwtToken.model.checker.JwtokenCheckToken;

public final class NodeJwtokenValidateL1 extends DeciTreeTemplateWriteV2<JwtokenInfo> {
	
	public NodeJwtokenValidateL1(DeciTreeOption<JwtokenInfo> option) {
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
		checker = new JwtokenCheckToken(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<JwtokenInfo>> buildActionsOnPassedHook(DeciTreeOption<JwtokenInfo> option) {
		List<ActionStdV1<JwtokenInfo>> actions = new ArrayList<>();
		
		ActionStdV1<JwtokenInfo> parse = new RootJwtokenParse(option).toAction();
		ActionLazyV1<JwtokenInfo> nodeL2 = new LazyJwtokenNodeValidateL2(option.conn, option.schemaName);
		
		parse.addPostAction(nodeL2);
		
		actions.add(parse);
		return actions;
	}
}
