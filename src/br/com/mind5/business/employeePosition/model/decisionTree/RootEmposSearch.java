package br.com.mind5.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposRootSelect;
import br.com.mind5.business.employeePosition.model.action.StdEmposMergeEmposarch;
import br.com.mind5.business.employeePosition.model.checker.EmposCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootEmposSearch extends DeciTreeTemplateRead<EmposInfo> {
	
	public RootEmposSearch(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmposInfo> buildCheckerHook(DeciTreeOption<EmposInfo> option) {
		List<ModelCheckerV1<EmposInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmposInfo> checker;

		checker = new EmposCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmposInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposInfo> option) {
		List<ActionStdV1<EmposInfo>> actions = new ArrayList<>();
		
		ActionStdV1<EmposInfo> mergeEmposarch	= new StdEmposMergeEmposarch(option);
		ActionLazyV1<EmposInfo> select = new LazyEmposRootSelect(option.conn, option.schemaName);
		
		mergeEmposarch.addPostAction(select);
		
		actions.add(mergeEmposarch);
		return actions;
	}
}
