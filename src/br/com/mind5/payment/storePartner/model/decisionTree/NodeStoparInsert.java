package br.com.mind5.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.StdStoparDaoInsert;
import br.com.mind5.payment.storePartner.model.action.StdStoparDaoUpdate;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckSoftDelete;

public final class NodeStoparInsert extends DeciTreeTemplateWriteV2<StoparInfo> {
	
	public NodeStoparInsert(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoparInfo> buildCheckerHook(DeciTreeOption<StoparInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelCheckerV1<StoparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoparInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new StoparCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStdV1<StoparInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoparDaoInsert(option));
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<StoparInfo>> buildActionsOnFailedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStdV1<StoparInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoparDaoUpdate(option));	
		return actions;
	}
}
