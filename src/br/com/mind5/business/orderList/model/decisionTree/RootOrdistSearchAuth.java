package br.com.mind5.business.orderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.LazyOrdistRootSearch;
import br.com.mind5.business.orderList.model.action.StdOrdistMergeUsername;
import br.com.mind5.business.orderList.model.checker.OrdistCheckSearchAuth;
import br.com.mind5.business.orderList.model.checker.OrdistCheckUsername;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootOrdistSearchAuth extends DeciTreeTemplateRead<OrdistInfo> {
	
	public RootOrdistSearchAuth(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdistInfo> buildCheckerHook(DeciTreeOption<OrdistInfo> option) {
		List<ModelCheckerV1<OrdistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdistCheckSearchAuth(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdistCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdistInfo> option) {
		List<ActionStdV1<OrdistInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<OrdistInfo> mergeUsername = new StdOrdistMergeUsername(option);
		ActionLazyV1<OrdistInfo> search = new LazyOrdistRootSearch(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(search);
		
		actions.add(mergeUsername);			
		return actions;
	}
}
