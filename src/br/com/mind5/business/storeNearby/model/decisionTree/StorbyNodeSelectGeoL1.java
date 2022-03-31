package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiNodeSelectGeoL2;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiGeoshGenerate;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiPruneEmpty;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StorbyNodeSelectGeoL1 extends DeciTreeTemplateRead<StorbyInfo> {
	
	public StorbyNodeSelectGeoL1(DeciTreeOption<StorbyInfo> option) {
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
		
		ActionStd<StorbyInfo> geoshGenerate = new ActionStdCommom<StorbyInfo>(option, StorbyVisiGeoshGenerate.class);
		ActionLazy<StorbyInfo> nodeL2 = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiNodeSelectGeoL2.class);
		ActionLazy<StorbyInfo> pruneEmpty = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiPruneEmpty.class);
		
		geoshGenerate.addPostAction(nodeL2);
		nodeL2.addPostAction(pruneEmpty);
		
		actions.add(geoshGenerate);			
		return actions;
	}
}
