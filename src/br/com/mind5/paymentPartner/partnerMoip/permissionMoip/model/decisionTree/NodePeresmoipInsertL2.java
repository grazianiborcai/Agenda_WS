package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.StdPeresmoipDaoInsert;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.StdPeresmoipSuccess;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckExist;

public final class NodePeresmoipInsertL2 extends DeciTreeTemplateWriteV2<PeresmoipInfo> {
	
	public NodePeresmoipInsertL2(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PeresmoipInfo> buildCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ModelCheckerV1<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PeresmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new PeresmoipCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStdV2<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStdV2<PeresmoipInfo> insert = new StdPeresmoipDaoInsert(option);	
		
		actions.add(insert);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<PeresmoipInfo>> buildActionsOnFailedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStdV2<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStdV2<PeresmoipInfo> success = new StdPeresmoipSuccess(option);	
		
		actions.add(success);		
		return actions;
	}
}
