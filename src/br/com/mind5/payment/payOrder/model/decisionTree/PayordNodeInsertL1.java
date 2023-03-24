package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.PayordVisiMergeCrecardAuth;
import br.com.mind5.payment.payOrder.model.action.PayordVisiMergeCuspar;
import br.com.mind5.payment.payOrder.model.action.PayordVisiNodeInsertL2;

public final class PayordNodeInsertL1 extends DeciTreeTemplateWrite<PayordInfo> {
	
	public PayordNodeInsertL1(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	

	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		
		
		ActionStd <PayordInfo> mergeCrecard = new ActionStdCommom <PayordInfo>(option, PayordVisiMergeCrecardAuth.class);
		ActionLazy<PayordInfo> mergeCuspar  = new ActionLazyCommom<PayordInfo>(option, PayordVisiMergeCuspar.class);
		ActionLazy<PayordInfo> nodeL2 	    = new ActionLazyCommom<PayordInfo>(option, PayordVisiNodeInsertL2.class);
		
		mergeCrecard.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(nodeL2);
	
		
		actions.add(mergeCrecard);		
		return actions;
	}
}
