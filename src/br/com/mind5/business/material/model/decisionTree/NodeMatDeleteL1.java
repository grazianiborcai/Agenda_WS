package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.StdMatMatoreDelete;
import br.com.mind5.business.material.model.checker.MatCheckMatore;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatDeleteL1 extends DeciTreeTemplateWriteV2<MatInfo> {
	
	public NodeMatDeleteL1(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelCheckerV1<MatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new MatCheckMatore(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueueV2<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV2<MatInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatInfo> nodeL2 = new NodeMatDeleteL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<MatInfo>> buildActionsOnFailedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV2<MatInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MatInfo> deleteMatore = new StdMatMatoreDelete(option);
		ActionStdV2<MatInfo> nodeL2 = new NodeMatDeleteL2(option).toAction();
		
		actions.add(deleteMatore);
		actions.add(nodeL2);
		return actions;
	}
}
