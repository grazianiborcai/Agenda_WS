package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.StdCremoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckSetupar;

public final class NodeCremoipSetuparL2 extends DeciTreeTemplateWrite<CremoipInfo> {
	
	public NodeCremoipSetuparL2(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CremoipInfo> buildCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelChecker<CremoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CremoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CremoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> mergeSetupar = new StdCremoipMergeSetupar(option);
		ActionLazy<CremoipInfo> mergeSysenv = new LazyCremoipMergeSysenv(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforceSetup = new LazyCremoipEnforceSetup(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
