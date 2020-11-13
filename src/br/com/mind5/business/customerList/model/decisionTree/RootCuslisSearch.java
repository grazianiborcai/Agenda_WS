package br.com.mind5.business.customerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.action.LazyCuslisRootSelect;
import br.com.mind5.business.customerList.model.action.StdCuslisMergeCusarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCuslisSearch extends DeciTreeTemplateReadV2<CuslisInfo> {
	
	public RootCuslisSearch(DeciTreeOption<CuslisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CuslisInfo> buildCheckerHook(DeciTreeOption<CuslisInfo> option) {
		List<ModelCheckerV1<CuslisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CuslisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CuslisInfo>> buildActionsOnPassedHook(DeciTreeOption<CuslisInfo> option) {
		List<ActionStdV2<CuslisInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CuslisInfo> mergeCusarch = new StdCuslisMergeCusarch(option);
		ActionLazy<CuslisInfo> select = new LazyCuslisRootSelect(option.conn, option.schemaName);
		
		mergeCusarch.addPostAction(select);
		
		actions.add(mergeCusarch);
		return actions;
	}
}
