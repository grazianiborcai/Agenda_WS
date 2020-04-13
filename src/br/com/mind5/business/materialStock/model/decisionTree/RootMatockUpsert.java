package br.com.mind5.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.checker.MatockCheckExist;
import br.com.mind5.business.materialStock.model.checker.MatockCheckWrite;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class RootMatockUpsert extends DeciTreeTemplateWriteV1<MatockInfo> {
	
	public RootMatockUpsert(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatockInfo> buildCheckerHook(DeciTreeOption<MatockInfo> option) {
		List<ModelCheckerV1<MatockInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatockInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatockCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStdV1<MatockInfo>> actions = new ArrayList<>();	
		ActionStdV1<MatockInfo> update = new RootMatockUpdate(option).toAction();	

		actions.add(update);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<MatockInfo>> buildActionsOnFailedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStdV1<MatockInfo>> actions = new ArrayList<>();	
		ActionStdV1<MatockInfo> insert = new RootMatockInsert(option).toAction();	

		actions.add(insert);
		return actions;
	}
}
