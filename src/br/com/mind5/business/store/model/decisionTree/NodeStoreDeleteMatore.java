package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StdStoreDeleteMatore;
import br.com.mind5.business.store.model.action.StdStoreSuccess;
import br.com.mind5.business.store.model.checker.StoreCheckHasMatore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreDeleteMatore extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreDeleteMatore(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {	
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckHasMatore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> deleteMatore = new StdStoreDeleteMatore(option);
		
		actions.add(deleteMatore);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnFailedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoreSuccess(option));		
		return actions;
	}
}
