package br.com.mind5.business.storeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.action.StolisVisiRootSelect;
import br.com.mind5.business.storeList.model.action.StolisVisiMergeSotarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class StolisRootSearch extends DeciTreeTemplateWrite<StolisInfo> {
	
	public StolisRootSearch(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolisInfo> buildCheckerHook(DeciTreeOption<StolisInfo> option) {
		List<ModelChecker<StolisInfo>> queue = new ArrayList<>();		
		ModelChecker<StolisInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolisInfo>> buildActionsOnPassedHook(DeciTreeOption<StolisInfo> option) {
		List<ActionStd<StolisInfo>> actions = new ArrayList<>();

		ActionStd<StolisInfo> mergeSotarch = new ActionStdCommom<StolisInfo>(option, StolisVisiMergeSotarch.class);
		ActionLazy<StolisInfo> select = new ActionLazyCommom<StolisInfo>(option, StolisVisiRootSelect.class);
		
		mergeSotarch.addPostAction(select);
		
		actions.add(mergeSotarch);
		return actions;
	}
}
