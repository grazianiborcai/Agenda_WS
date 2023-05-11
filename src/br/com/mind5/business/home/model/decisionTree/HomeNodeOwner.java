package br.com.mind5.business.home.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.model.action.HomeVisiMergeSowash;
import br.com.mind5.business.home.model.action.HomeVisiMergeStoprosou;
import br.com.mind5.business.home.model.checker.HomeCheckAuthOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class HomeNodeOwner extends DeciTreeTemplateRead<HomeInfo> {
	
	public HomeNodeOwner(DeciTreeOption<HomeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<HomeInfo> buildCheckerHook(DeciTreeOption<HomeInfo> option) {
		List<ModelChecker<HomeInfo>> queue = new ArrayList<>();		
		ModelChecker<HomeInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new HomeCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<HomeInfo>> buildActionsOnPassedHook(DeciTreeOption<HomeInfo> option) {
		List<ActionStd<HomeInfo>> actions = new ArrayList<>();		
		
		ActionStd <HomeInfo> mergeStoprosou = new ActionStdCommom <HomeInfo>(option, HomeVisiMergeStoprosou.class);
		ActionLazy<HomeInfo> mergeSowash    = new ActionLazyCommom<HomeInfo>(option, HomeVisiMergeSowash.class);
		
		mergeStoprosou.addPostAction(mergeSowash);
		
		actions.add(mergeStoprosou);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<HomeInfo>> buildActionsOnFailedHook(DeciTreeOption<HomeInfo> option) {
		List<ActionStd<HomeInfo>> actions = new ArrayList<>();		
		
		ActionStd<HomeInfo> sucess = new ActionStdSuccessCommom<HomeInfo>(option);
		
		actions.add(sucess);	
		return actions;
	}
}
