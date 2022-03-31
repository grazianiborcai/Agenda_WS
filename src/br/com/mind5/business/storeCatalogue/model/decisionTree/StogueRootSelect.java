package br.com.mind5.business.storeCatalogue.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.business.storeCatalogue.model.action.StogueVisiMergeMatoup;
import br.com.mind5.business.storeCatalogue.model.action.StogueVisiMergeOwnelis;
import br.com.mind5.business.storeCatalogue.model.action.StogueVisiMergeStorby;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StogueRootSelect extends DeciTreeTemplateRead<StogueInfo> {
	
	public StogueRootSelect(DeciTreeOption<StogueInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StogueInfo> buildCheckerHook(DeciTreeOption<StogueInfo> option) {
		List<ModelChecker<StogueInfo>> queue = new ArrayList<>();		
		ModelChecker<StogueInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StogueInfo>> buildActionsOnPassedHook(DeciTreeOption<StogueInfo> option) {
		List<ActionStd<StogueInfo>> actions = new ArrayList<>();		
		
		ActionStd<StogueInfo> mergeStorby = new ActionStdCommom<StogueInfo>(option, StogueVisiMergeStorby.class);
		ActionLazy<StogueInfo> mergeOwnelis = new ActionLazyCommom<StogueInfo>(option, StogueVisiMergeOwnelis.class);
		ActionLazy<StogueInfo> mergeMatoup = new ActionLazyCommom<StogueInfo>(option, StogueVisiMergeMatoup.class);
		
		mergeStorby.addPostAction(mergeOwnelis);
		mergeOwnelis.addPostAction(mergeMatoup);
		
		actions.add(mergeStorby);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
