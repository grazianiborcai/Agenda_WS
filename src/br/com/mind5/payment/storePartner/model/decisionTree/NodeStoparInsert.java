package br.com.mind5.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.StdStoparInsert;
import br.com.mind5.payment.storePartner.model.action.StdStoparUpdate;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckSoftDelete;

public final class NodeStoparInsert extends DeciTreeWriteTemplate<StoparInfo> {
	
	public NodeStoparInsert(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildDecisionCheckerHook(DeciTreeOption<StoparInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStdV1<StoparInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoparInsert(option));
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StoparInfo>> buildActionsOnFailedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStdV1<StoparInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoparUpdate(option));	
		return actions;
	}
}
