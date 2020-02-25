package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeCusparRefL1;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeUser;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckDummy;

public final class RootCrecardSelectAuth extends DeciTreeReadTemplate<CrecardInfo> {
	
	public RootCrecardSelectAuth(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;

		checker = new CrecardCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecardInfo> select = new RootCrecardSelect(option).toAction();
		ActionLazy<CrecardInfo> user = new LazyCrecardNodeUser(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> cusparRef = new LazyCrecardNodeCusparRefL1(option.conn, option.schemaName);
		
		select.addPostAction(user);
		user.addPostAction(cusparRef);
		
		actions.add(select);
		return actions;
	}
}
