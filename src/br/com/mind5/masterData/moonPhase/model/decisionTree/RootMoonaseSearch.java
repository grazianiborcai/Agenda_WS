package br.com.mind5.masterData.moonPhase.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.action.LazyMoonaseRootSelect;
import br.com.mind5.masterData.moonPhase.model.action.StdMoonaseMergeMoonasarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootMoonaseSearch extends DeciTreeTemplateWrite<MoonaseInfo> {
	
	public RootMoonaseSearch(DeciTreeOption<MoonaseInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MoonaseInfo> buildCheckerHook(DeciTreeOption<MoonaseInfo> option) {
		List<ModelChecker<MoonaseInfo>> queue = new ArrayList<>();		
		ModelChecker<MoonaseInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MoonaseInfo>> buildActionsOnPassedHook(DeciTreeOption<MoonaseInfo> option) {
		List<ActionStd<MoonaseInfo>> actions = new ArrayList<>();		
		
		ActionStd<MoonaseInfo> mergeMoonasarch = new StdMoonaseMergeMoonasarch(option);		
		ActionLazy<MoonaseInfo> select = new LazyMoonaseRootSelect(option.conn, option.schemaName);
		
		mergeMoonasarch.addPostAction(select);
		
		actions.add(mergeMoonasarch);			
		return actions;
	}
}
