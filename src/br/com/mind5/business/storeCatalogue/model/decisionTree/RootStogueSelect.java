package br.com.mind5.business.storeCatalogue.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.business.storeCatalogue.model.action.LazyStogueMergeMatoup;
import br.com.mind5.business.storeCatalogue.model.action.LazyStogueMergeOwnelis;
import br.com.mind5.business.storeCatalogue.model.action.StdStogueMergeStorby;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStogueSelect extends DeciTreeTemplateReadV2<StogueInfo> {
	
	public RootStogueSelect(DeciTreeOption<StogueInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StogueInfo> buildCheckerHook(DeciTreeOption<StogueInfo> option) {
		List<ModelCheckerV1<StogueInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StogueInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StogueInfo>> buildActionsOnPassedHook(DeciTreeOption<StogueInfo> option) {
		List<ActionStdV2<StogueInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<StogueInfo> mergeStorby = new StdStogueMergeStorby(option);
		ActionLazy<StogueInfo> mergeOwnelis = new LazyStogueMergeOwnelis(option.conn, option.schemaName);
		ActionLazy<StogueInfo> mergeMatoup = new LazyStogueMergeMatoup(option.conn, option.schemaName);
		
		mergeStorby.addPostAction(mergeOwnelis);
		mergeOwnelis.addPostAction(mergeMatoup);
		
		actions.add(mergeStorby);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
