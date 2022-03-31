package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiEnforceDistance;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeAddress;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeComplis;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeFimeco;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeMatopore;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeStorext;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeStorite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StorbyNodeMerge extends DeciTreeTemplateRead<StorbyInfo> {
	
	public StorbyNodeMerge(DeciTreeOption<StorbyInfo> option) {
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
		
		ActionStd<StorbyInfo> mergeComplis = new ActionStdCommom<StorbyInfo>(option, StorbyVisiMergeComplis.class);
		ActionLazy<StorbyInfo> mergeAddress = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiMergeAddress.class);
		ActionLazy<StorbyInfo> enforceDistance = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiEnforceDistance.class);
		ActionLazy<StorbyInfo> mergeFimeco = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiMergeFimeco.class);
		ActionLazy<StorbyInfo> mergeMatopore = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiMergeMatopore.class);
		ActionLazy<StorbyInfo> mergeStorite = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiMergeStorite.class);
		ActionLazy<StorbyInfo> mergeStorext = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiMergeStorext.class);
		
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(enforceDistance);
		enforceDistance.addPostAction(mergeFimeco);
		mergeFimeco.addPostAction(mergeMatopore);
		mergeMatopore.addPostAction(mergeStorite);
		mergeStorite.addPostAction(mergeStorext);
		
		actions.add(mergeComplis);			
		return actions;
	}
}
