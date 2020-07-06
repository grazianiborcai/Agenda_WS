package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.StdStorbyEnforceHash01Key;
import br.com.mind5.business.storeNearby.model.action.StdStorbyEnforceHash02Key;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckExistHash02;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeStorbyHashL3 extends DeciTreeTemplateReadV2<StorbyInfo> {
	
	public NodeStorbyHashL3(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelCheckerV1<StorbyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorbyInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorbyCheckExistHash02(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV1<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorbyInfo> enforceHashKey = new StdStorbyEnforceHash02Key(option);
		
		actions.add(enforceHashKey);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StorbyInfo>> buildActionsOnFailedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV1<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorbyInfo> enforceHashKey = new StdStorbyEnforceHash01Key(option);
		
		actions.add(enforceHashKey);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}