package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyEnforceDistance;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeAddress;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyPruneDistance50;
import br.com.mind5.business.storeNearby.model.action.StdStorbyMergeComplis;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeStorbyDistance50 extends DeciTreeTemplateReadV2<StorbyInfo> {
	
	public NodeStorbyDistance50(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelCheckerV1<StorbyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorbyInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV1<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorbyInfo> mergeComplis = new StdStorbyMergeComplis(option);
		ActionLazy<StorbyInfo> mergeAddress = new LazyStorbyMergeAddress(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> enforceDistance = new LazyStorbyEnforceDistance(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> pruneDistance50 = new LazyStorbyPruneDistance50(option.conn, option.schemaName);
		
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(enforceDistance);
		enforceDistance.addPostAction(pruneDistance50);
		
		actions.add(mergeComplis);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
