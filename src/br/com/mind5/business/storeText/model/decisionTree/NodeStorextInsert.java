package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.StdStorextDaoInsert;
import br.com.mind5.business.storeText.model.action.StdStorextDaoUpdate;
import br.com.mind5.business.storeText.model.checker.StorextCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorextInsert extends DeciTreeTemplateWriteV2<StorextInfo> {
	
	public NodeStorextInsert(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelCheckerV1<StorextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StorextCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV1<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorextInfo> insert = new StdStorextDaoInsert(option);
		actions.add(insert);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StorextInfo>> buildActionsOnFailedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV1<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorextInfo> update = new StdStorextDaoUpdate(option);
		actions.add(update);
		
		return actions;
	}
}
