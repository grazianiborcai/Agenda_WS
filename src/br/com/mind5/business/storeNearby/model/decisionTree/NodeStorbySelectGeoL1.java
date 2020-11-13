package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyNodeSelectGeoL2;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyPruneEmpty;
import br.com.mind5.business.storeNearby.model.action.StdStorbyGeoshGenerate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeStorbySelectGeoL1 extends DeciTreeTemplateReadV2<StorbyInfo> {
	
	public NodeStorbySelectGeoL1(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelCheckerV1<StorbyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorbyInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV2<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<StorbyInfo> geoshGenerate = new StdStorbyGeoshGenerate(option);
		ActionLazy<StorbyInfo> nodeL2 = new LazyStorbyNodeSelectGeoL2(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> pruneEmpty = new LazyStorbyPruneEmpty(option.conn, option.schemaName);
		
		geoshGenerate.addPostAction(nodeL2);
		nodeL2.addPostAction(pruneEmpty);
		
		actions.add(geoshGenerate);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
