package br.com.mind5.business.customerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.action.LazyCuslisRootSelect;
import br.com.mind5.business.customerList.model.action.StdCuslisMergeCusarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCuslisSearchAuth extends DeciTreeTemplateRead<CuslisInfo> {
	
	public RootCuslisSearchAuth(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CuslisInfo> buildCheckerHook(DeciTreeOption<CuslisInfo> option) {
		List<ModelChecker<CuslisInfo>> queue = new ArrayList<>();		
		ModelChecker<CuslisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
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
