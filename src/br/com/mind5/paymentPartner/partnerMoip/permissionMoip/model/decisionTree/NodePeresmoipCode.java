package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipDaoDelete;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipTokemoipGenerate;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.LazyPeresmoipStoparInsert;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action.StdPeresmoipEnforceExpected;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker.PeresmoipCheckIsExpected;

public final class NodePeresmoipCode extends DeciTreeTemplateWriteV2<PeresmoipInfo> {
	
	public NodePeresmoipCode(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PeresmoipInfo> buildCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ModelCheckerV1<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PeresmoipInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PeresmoipCheckIsExpected(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStdV1<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStdV1<PeresmoipInfo> enforceExpected = new StdPeresmoipEnforceExpected(option);
		ActionLazyV1<PeresmoipInfo> enforcePaypar = new LazyPeresmoipEnforcePaypar(option.conn, option.schemaName);
		ActionLazyV1<PeresmoipInfo> generateTokemoip = new LazyPeresmoipTokemoipGenerate(option.conn, option.schemaName);	
		ActionLazyV1<PeresmoipInfo> insertStopar = new LazyPeresmoipStoparInsert(option.conn, option.schemaName);	
		ActionLazyV1<PeresmoipInfo> delete = new LazyPeresmoipDaoDelete(option.conn, option.schemaName);	
		
		enforceExpected.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(generateTokemoip);
		generateTokemoip.addPostAction(insertStopar);
		insertStopar.addPostAction(delete);
		
		actions.add(enforceExpected);		
		return actions;
	}
}
