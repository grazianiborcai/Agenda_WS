package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.StdCremoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckSetupar;

public final class NodeCremoipSetuparL2 extends DeciTreeTemplateWriteV2<CremoipInfo> {
	
	public NodeCremoipSetuparL2(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CremoipInfo> buildCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelCheckerV1<CremoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CremoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CremoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStdV1<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CremoipInfo> mergeSetupar = new StdCremoipMergeSetupar(option);
		ActionLazyV1<CremoipInfo> mergeSysenv = new LazyCremoipMergeSysenv(option.conn, option.schemaName);
		ActionLazyV1<CremoipInfo> enforceSetup = new LazyCremoipEnforceSetup(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
