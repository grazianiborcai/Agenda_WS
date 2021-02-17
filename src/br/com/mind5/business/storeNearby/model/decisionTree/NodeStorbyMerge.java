package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyEnforceDistance;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeAddress;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeFimeco;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeMatopore;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeStorext;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeStorite;
import br.com.mind5.business.storeNearby.model.action.StdStorbyMergeComplis;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeStorbyMerge extends DeciTreeTemplateRead<StorbyInfo> {
	
	public NodeStorbyMerge(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelChecker<StorbyInfo>> queue = new ArrayList<>();		
		ModelChecker<StorbyInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStd<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorbyInfo> mergeComplis = new StdStorbyMergeComplis(option);
		ActionLazy<StorbyInfo> mergeAddress = new LazyStorbyMergeAddress(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> enforceDistance = new LazyStorbyEnforceDistance(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> mergeFimeco = new LazyStorbyMergeFimeco(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> mergeMatopore = new LazyStorbyMergeMatopore(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> mergeStorite = new LazyStorbyMergeStorite(option.conn, option.schemaName);
		ActionLazy<StorbyInfo> mergeStorext = new LazyStorbyMergeStorext(option.conn, option.schemaName);
		
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(enforceDistance);
		enforceDistance.addPostAction(mergeFimeco);
		mergeFimeco.addPostAction(mergeMatopore);
		mergeMatopore.addPostAction(mergeStorite);
		mergeStorite.addPostAction(mergeStorext);
		
		actions.add(mergeComplis);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
