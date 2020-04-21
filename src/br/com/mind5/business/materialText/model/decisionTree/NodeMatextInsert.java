package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.StdMatextDaoInsert;
import br.com.mind5.business.materialText.model.action.StdMatextDaoUpdate;
import br.com.mind5.business.materialText.model.checker.MatextCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeMatextInsert extends DeciTreeTemplateWriteV2<MatextInfo> {
	
	public NodeMatextInsert(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatextInfo> buildCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelCheckerV1<MatextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new MatextCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextInfo> insert = new StdMatextDaoInsert(option);
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextInfo> update = new StdMatextDaoUpdate(option);
		actions.add(update);
		
		return actions;
	}
}
