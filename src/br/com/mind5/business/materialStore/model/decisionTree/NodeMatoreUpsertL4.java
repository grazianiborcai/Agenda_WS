package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckIsProduct;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatoreUpsertL4 extends DeciTreeTemplateWrite<MatoreInfo> {
	
	public NodeMatoreUpsertL4(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatoreInfo> buildCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelCheckerV1<MatoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatoreInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatoreCheckIsProduct(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV1<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatoreInfo> nodeL5 = new NodeMatoreUpsertL5(option).toAction();		
		actions.add(nodeL5);
		
		return actions;
	}
}
