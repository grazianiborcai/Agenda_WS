package br.com.mind5.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.LazyStoparUpdate;
import br.com.mind5.payment.storePartner.model.action.StdStoparInsertStoparnap;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckWrite;

public final class NodeStoparSnapshot extends DeciTreeTemplateWriteV1<StoparInfo> {
	
	public NodeStoparSnapshot(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoparInfo> buildCheckerHook(DeciTreeOption<StoparInfo> option) {
		List<ModelCheckerV1<StoparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoparCheckWrite(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStdV1<StoparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoparInfo> InsertStoparnap = new StdStoparInsertStoparnap(option); 
		ActionLazyV1<StoparInfo> updateStopar = new LazyStoparUpdate(option.conn, option.schemaName); 
		
		InsertStoparnap.addPostAction(updateStopar);
		
		actions.add(InsertStoparnap);
		return actions;
	}
}
