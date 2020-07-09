package br.com.mind5.authorization.customerAuthorization.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.authorization.customerAuthorization.model.checker.CusauthCheckHasStore;
import br.com.mind5.authorization.customerAuthorization.model.checker.CusauthCheckStore;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCusauthSelectL2 extends DeciTreeTemplateWriteV2<CusauthInfo> {
	
	public NodeCusauthSelectL2(DeciTreeOption<CusauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusauthInfo> buildCheckerHook(DeciTreeOption<CusauthInfo> option) {
		List<ModelCheckerV1<CusauthInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusauthInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new CusauthCheckHasStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;			
		checker = new CusauthCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusauthInfo>> buildActionsOnPassedHook(DeciTreeOption<CusauthInfo> option) {
		List<ActionStdV1<CusauthInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusauthInfo> nodeL3 = new NodeCusauthSelectL3(option).toAction();
		
		actions.add(nodeL3);
		return actions;
	}
}
