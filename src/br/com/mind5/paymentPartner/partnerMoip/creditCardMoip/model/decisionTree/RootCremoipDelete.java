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
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipDelete;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipNodeCusparL1;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckCuspar;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckDelete;

public final class RootCremoipDelete extends DeciTreeTemplateWrite<CremoipInfo> {
	
	public RootCremoipDelete(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CremoipInfo> buildCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelChecker<CremoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CremoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CremoipCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CremoipCheckCuspar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> nodeSetupar = new NodeCremoipSetuparL1(option).toAction();
		ActionLazy<CremoipInfo> nodeCuspar = new LazyCremoipNodeCusparL1(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> delete = new LazyCremoipDelete(option.conn, option.schemaName);
		
		nodeSetupar.addPostAction(nodeCuspar);
		nodeCuspar.addPostAction(delete);
		
		actions.add(nodeSetupar);
		return actions;
	}
}
