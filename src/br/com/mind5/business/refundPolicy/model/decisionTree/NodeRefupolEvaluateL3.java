package br.com.mind5.business.refundPolicy.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.business.refundPolicy.model.action.StdRefupolSuccess;
import br.com.mind5.business.refundPolicy.model.checker.RefupolCheckMatarchService;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeRefupolEvaluateL3 extends DeciTreeTemplateWriteV2<RefupolInfo> {
	
	public NodeRefupolEvaluateL3(DeciTreeOption<RefupolInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefupolInfo> buildCheckerHook(DeciTreeOption<RefupolInfo> option) {
		List<ModelCheckerV1<RefupolInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefupolInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new RefupolCheckMatarchService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<RefupolInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupolInfo> option) {
		List<ActionStdV2<RefupolInfo>> actions = new ArrayList<>();
		
		ActionStdV2<RefupolInfo> nodeL4 = new NodeRefupolEvaluateL4(option).toAction();
		
		actions.add(nodeL4);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<RefupolInfo>> buildActionsOnFailedHook(DeciTreeOption<RefupolInfo> option) {
		List<ActionStdV2<RefupolInfo>> actions = new ArrayList<>();
		
		ActionStdV2<RefupolInfo> success = new StdRefupolSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
