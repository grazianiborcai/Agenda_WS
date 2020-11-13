package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.checker.StorextCheckIsDeleted;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorextUpsertdelL1 extends DeciTreeTemplateWriteV2<StorextInfo> {
	
	public NodeStorextUpsertdelL1(DeciTreeOption<StorextInfo> option) {
		super(option);
	}	
	
	
	
	@Override protected ModelCheckerV1<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelCheckerV1<StorextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorextCheckIsDeleted(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV2<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StorextInfo> delete = new RootStorextDelete(option).toAction();
		
		actions.add(delete);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<StorextInfo>> buildActionsOnFailedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV2<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StorextInfo> nodeL2 = new NodeStorextUpsertdelL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
