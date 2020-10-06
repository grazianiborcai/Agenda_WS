package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyEnforceDistance;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeAddress;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeFimist;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeMatopore;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeStorext;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeStorite;
import br.com.mind5.business.storeNearby.model.action.StdStorbyMergeComplis;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorbyMerge extends DeciTreeTemplateWriteV2<StorbyInfo> {
	
	public NodeStorbyMerge(DeciTreeOption<StorbyInfo> option) {
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
		ActionLazyV1<StorbyInfo> mergeAddress = new LazyStorbyMergeAddress(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> enforceDistance = new LazyStorbyEnforceDistance(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> mergeFimist = new LazyStorbyMergeFimist(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> mergeMatopore = new LazyStorbyMergeMatopore(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> mergeStorite = new LazyStorbyMergeStorite(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> mergeStorext = new LazyStorbyMergeStorext(option.conn, option.schemaName);
		
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(enforceDistance);
		enforceDistance.addPostAction(mergeFimist);
		mergeFimist.addPostAction(mergeMatopore);
		mergeMatopore.addPostAction(mergeStorite);
		mergeStorite.addPostAction(mergeStorext);
		
		actions.add(mergeComplis);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
