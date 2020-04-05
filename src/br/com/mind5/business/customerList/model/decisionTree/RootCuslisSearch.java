package br.com.mind5.business.customerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.action.LazyCuslisRootSelect;
import br.com.mind5.business.customerList.model.action.StdCuslisMergeCusarch;
import br.com.mind5.business.customerList.model.checker.CuslisCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCuslisSearch extends DeciTreeReadTemplate<CuslisInfo> {
	
	public RootCuslisSearch(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CuslisInfo> buildCheckerHook(DeciTreeOption<CuslisInfo> option) {
		List<ModelChecker<CuslisInfo>> queue = new ArrayList<>();		
		ModelChecker<CuslisInfo> checker;

		checker = new CuslisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CuslisInfo>> buildActionsOnPassedHook(DeciTreeOption<CuslisInfo> option) {
		List<ActionStdV1<CuslisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CuslisInfo> mergeCusarch = new StdCuslisMergeCusarch(option);
		ActionLazyV1<CuslisInfo> select = new LazyCuslisRootSelect(option.conn, option.schemaName);
		
		mergeCusarch.addPostAction(select);
		
		actions.add(mergeCusarch);
		return actions;
	}
}
