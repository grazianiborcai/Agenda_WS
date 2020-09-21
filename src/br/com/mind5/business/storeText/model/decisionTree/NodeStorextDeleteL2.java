package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.StdStorextSuccess;
import br.com.mind5.business.storeText.model.checker.StorextCheckStorextault;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorextDeleteL2 extends DeciTreeTemplateWriteV2<StorextInfo> {

	public NodeStorextDeleteL2(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelCheckerV1<StorextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorextCheckStorextault(checkerOption);
		queue.add(checker);		

		return new ModelCheckerHelperQueueV2<StorextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV1<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorextInfo> success = new StdStorextSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StorextInfo>> buildActionsOnFailedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV1<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorextInfo> nodeL3 = new NodeStorextDeleteL3(option).toAction();
		
		actions.add(nodeL3);
		return actions;
	}
}
