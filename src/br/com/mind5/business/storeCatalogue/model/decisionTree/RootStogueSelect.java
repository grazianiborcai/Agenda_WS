package br.com.mind5.business.storeCatalogue.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.business.storeCatalogue.model.action.LazyStogueMergeMatoup;
import br.com.mind5.business.storeCatalogue.model.action.LazyStogueMergeOwnelis;
import br.com.mind5.business.storeCatalogue.model.action.StdStogueMergeStorby;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootStogueSelect extends DeciTreeTemplateRead<StogueInfo> {
	
	public RootStogueSelect(DeciTreeOption<StogueInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StogueInfo> buildCheckerHook(DeciTreeOption<StogueInfo> option) {
		List<ModelChecker<StogueInfo>> queue = new ArrayList<>();		
		ModelChecker<StogueInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StogueInfo>> buildActionsOnPassedHook(DeciTreeOption<StogueInfo> option) {
		List<ActionStd<StogueInfo>> actions = new ArrayList<>();		
		
		ActionStd<StogueInfo> mergeStorby = new StdStogueMergeStorby(option);
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
