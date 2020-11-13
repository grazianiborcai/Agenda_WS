package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyRootSelectGeoL4;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckExistHash02;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeStorbySelectGeoL3 extends DeciTreeTemplateReadV2<StorbyInfo> {
	
	public NodeStorbySelectGeoL3(DeciTreeOption<StorbyInfo> option) {
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
		
		ActionStdV1<StorbyInfo> selectHash02 = new RootStorbySelectHash02(option).toAction();
		ActionLazy<StorbyInfo> nodeL4 = new LazyStorbyRootSelectGeoL4(option.conn, option.schemaName);
		
		selectHash02.addPostAction(nodeL4);
		
		actions.add(selectHash02);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StorbyInfo>> buildActionsOnFailedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV1<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorbyInfo> selectHash01 = new RootStorbySelectHash01(option).toAction();
		
		actions.add(selectHash01);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
