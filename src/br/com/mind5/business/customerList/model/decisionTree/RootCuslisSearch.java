package br.com.mind5.business.customerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.action.LazyCuslisRootSelect;
import br.com.mind5.business.customerList.model.action.StdCuslisMergeCusarch;
import br.com.mind5.business.customerList.model.checker.CuslisCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCuslisSearch extends DeciTreeReadTemplate<CuslisInfo> {
	
	public RootCuslisSearch(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CuslisInfo> buildDecisionCheckerHook(DeciTreeOption<CuslisInfo> option) {
		List<ModelChecker<CuslisInfo>> queue = new ArrayList<>();		
		ModelChecker<CuslisInfo> checker;

		checker = new CuslisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CuslisInfo>> buildActionsOnPassedHook(DeciTreeOption<CuslisInfo> option) {
		List<ActionStd<CuslisInfo>> actions = new ArrayList<>();
		
		ActionStd<CuslisInfo> mergeCusarch = new StdCuslisMergeCusarch(option);
		ActionLazy<CuslisInfo> select = new LazyCuslisRootSelect(option.conn, option.schemaName);
		
		mergeCusarch.addPostAction(select);
		
		actions.add(mergeCusarch);
		return actions;
	}
}
