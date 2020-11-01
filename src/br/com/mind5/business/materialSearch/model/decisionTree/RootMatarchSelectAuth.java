package br.com.mind5.business.materialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.action.LazyMatarchRootSelect;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMatarchSelectAuth extends DeciTreeTemplateReadV2<MatarchInfo> {
	
	public RootMatarchSelectAuth(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatarchInfo> buildCheckerHook(DeciTreeOption<MatarchInfo> option) {
		List<ModelCheckerV1<MatarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatarchInfo> option) {
		List<ActionStdV1<MatarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatarchInfo> nodeAuth = new NodeMatarchAuth(option).toAction();
		ActionLazyV1<MatarchInfo> select = new LazyMatarchRootSelect(option.conn, option.schemaName);
		
		nodeAuth.addPostAction(select);
		
		actions.add(nodeAuth);
		return actions;
	}
}
