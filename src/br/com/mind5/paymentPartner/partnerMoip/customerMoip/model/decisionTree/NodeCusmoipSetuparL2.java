package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.StdCusmoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckSetupar;

public final class NodeCusmoipSetuparL2 extends DeciTreeTemplateWriteV2<CusmoipInfo> {
	
	public NodeCusmoipSetuparL2(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusmoipInfo> buildCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelCheckerV1<CusmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusmoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStdV1<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusmoipInfo> mergeSetupar = new StdCusmoipMergeSetupar(option);
		ActionLazyV1<CusmoipInfo> mergeSysenv = new LazyCusmoipMergeSysenv(option.conn, option.schemaName);
		ActionLazyV1<CusmoipInfo> enforceSetup = new LazyCusmoipEnforceSetup(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
