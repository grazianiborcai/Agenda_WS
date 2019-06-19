package br.com.gda.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.action.LazyStoparUpdate;
import br.com.gda.payment.storePartner.model.action.StdStoparInsertStoparnap;
import br.com.gda.payment.storePartner.model.checker.StoparCheckWrite;

public final class NodeStoparSnapshot extends DeciTreeWriteTemplate<StoparInfo> {
	
	public NodeStoparSnapshot(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildDecisionCheckerHook(DeciTreeOption<StoparInfo> option) {
		List<ModelChecker<StoparInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparInfo> checker;

		checker = new StoparCheckWrite();
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();
		
		ActionStd<StoparInfo> InsertStoparnap = new StdStoparInsertStoparnap(option); 
		ActionLazy<StoparInfo> updateStopar = new LazyStoparUpdate(option.conn, option.schemaName); 
		
		InsertStoparnap.addPostAction(updateStopar);
		
		actions.add(InsertStoparnap);
		return actions;
	}
}
