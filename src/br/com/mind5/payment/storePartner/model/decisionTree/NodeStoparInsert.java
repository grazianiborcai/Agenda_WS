package br.com.mind5.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.StdStoparDaoInsert;
import br.com.mind5.payment.storePartner.model.action.StdStoparDaoUpdate;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckSoftDelete;

public final class NodeStoparInsert extends DeciTreeTemplateWrite<StoparInfo> {
	
	public NodeStoparInsert(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildCheckerHook(DeciTreeOption<StoparInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<StoparInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new StoparCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoparDaoInsert(option));
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnFailedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoparDaoUpdate(option));	
		return actions;
	}
}
