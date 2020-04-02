package br.com.mind5.masterData.moonPhase.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.action.LazyMoonaseRootSelect;
import br.com.mind5.masterData.moonPhase.model.action.StdMoonaseMergeMoonasarch;
import br.com.mind5.masterData.moonPhase.model.checker.MoonaseCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMoonaseSearch extends DeciTreeWriteTemplate<MoonaseInfo> {
	
	public RootMoonaseSearch(DeciTreeOption<MoonaseInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MoonaseInfo> buildDecisionCheckerHook(DeciTreeOption<MoonaseInfo> option) {
		List<ModelChecker<MoonaseInfo>> queue = new ArrayList<>();		
		ModelChecker<MoonaseInfo> checker;	

		checker = new MoonaseCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MoonaseInfo>> buildActionsOnPassedHook(DeciTreeOption<MoonaseInfo> option) {
		List<ActionStdV1<MoonaseInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MoonaseInfo> mergeMoonasarch = new StdMoonaseMergeMoonasarch(option);		
		ActionLazyV1<MoonaseInfo> select = new LazyMoonaseRootSelect(option.conn, option.schemaName);
		
		mergeMoonasarch.addPostAction(select);
		
		actions.add(mergeMoonasarch);			
		return actions;
	}
}
