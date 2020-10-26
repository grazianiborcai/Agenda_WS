package br.com.mind5.businessContent.material.main.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.businessContent.material.main.model.action.StdMatbcinMatbcetInsert;
import br.com.mind5.businessContent.material.main.model.action.StdMatbcinSuccess;
import br.com.mind5.businessContent.material.main.model.checker.MatbcinCheckIsPetshop;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatbcinInsertL2 extends DeciTreeTemplateWriteV2<MatbcinInfo> {
	
	public NodeMatbcinInsertL2(DeciTreeOption<MatbcinInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatbcinInfo> buildCheckerHook(DeciTreeOption<MatbcinInfo> option) {
		List<ModelCheckerV1<MatbcinInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatbcinInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatbcinCheckIsPetshop(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatbcinInfo>> buildActionsOnPassedHook(DeciTreeOption<MatbcinInfo> option) {
		List<ActionStdV1<MatbcinInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MatbcinInfo> insertMatbcet = new StdMatbcinMatbcetInsert(option);
		
		actions.add(insertMatbcet);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<MatbcinInfo>> buildActionsOnFailedHook(DeciTreeOption<MatbcinInfo> option) {
		List<ActionStdV1<MatbcinInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MatbcinInfo> success = new StdMatbcinSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
