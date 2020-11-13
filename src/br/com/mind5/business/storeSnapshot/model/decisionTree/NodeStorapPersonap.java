package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapMergePersonap;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapSuccess;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckHasPersonap;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeStorapPersonap extends DeciTreeTemplateWrite<StorapInfo> {
	
	public NodeStorapPersonap(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorapInfo> buildCheckerHook(DeciTreeOption<StorapInfo> option) {		
		List<ModelChecker<StorapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorapInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorapCheckHasPersonap(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> mergePersonap = new StdStorapMergePersonap(option);
		
		actions.add(mergePersonap);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnFailedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> success = new StdStorapSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
