package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StdStoreDeleteStowotm;
import br.com.mind5.business.store.model.action.StdStoreSuccess;
import br.com.mind5.business.store.model.checker.StoreCheckStowotarch;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreDeleteStowotm extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreDeleteStowotm(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckStowotarch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStdV1<StoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoreInfo> deleteStowotm = new StdStoreDeleteStowotm(option);
		
		actions.add(deleteStowotm);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StoreInfo>> buildActionsOnFailedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStdV1<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoreSuccess(option));		
		return actions;
	}
}
