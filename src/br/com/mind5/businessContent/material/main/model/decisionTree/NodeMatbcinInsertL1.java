package br.com.mind5.businessContent.material.main.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.businessContent.material.main.model.action.LazyMatbcinNodeInsertL2;
import br.com.mind5.businessContent.material.main.model.action.StdMatbcinMergeOwnelis;
import br.com.mind5.businessContent.material.main.model.action.StdMatbcinSuccess;
import br.com.mind5.businessContent.material.main.model.checker.MatbcinCheckSytorbc;
import br.com.mind5.businessContent.material.main.model.checker.MatbcinCheckSytotin;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatbcinInsertL1 extends DeciTreeTemplateWriteV2<MatbcinInfo> {
	
	public NodeMatbcinInsertL1(DeciTreeOption<MatbcinInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatbcinInfo> buildCheckerHook(DeciTreeOption<MatbcinInfo> option) {
		List<ModelCheckerV1<MatbcinInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatbcinInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatbcinCheckSytotin(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatbcinCheckSytorbc(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MatbcinInfo>> buildActionsOnPassedHook(DeciTreeOption<MatbcinInfo> option) {
		List<ActionStdV2<MatbcinInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<MatbcinInfo> mergeOwnelis = new StdMatbcinMergeOwnelis(option);
		ActionLazy<MatbcinInfo> nodeL2 = new LazyMatbcinNodeInsertL2(option.conn, option.schemaName);
		
		mergeOwnelis.addPostAction(nodeL2);
		
		actions.add(mergeOwnelis);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<MatbcinInfo>> buildActionsOnFailedHook(DeciTreeOption<MatbcinInfo> option) {
		List<ActionStdV2<MatbcinInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<MatbcinInfo> success = new StdMatbcinSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
