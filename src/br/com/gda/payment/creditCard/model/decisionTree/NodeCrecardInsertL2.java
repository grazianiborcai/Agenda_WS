package br.com.gda.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.action.LazyCrecardInsert;
import br.com.gda.payment.creditCard.model.action.StdCrecardInsertCuspar;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckHasPaypar;
import br.com.gda.payment.creditCard.model.checker.CrecardCheckUserRef;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCrecardInsertL2 extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public NodeCrecardInsertL2(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;	
		
		checker = new CrecardCheckHasPaypar();
		queue.add(checker);
		
		checker = new CrecardCheckUserRef();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo> insertCuspar = new  StdCrecardInsertCuspar(option);
		ActionLazy<CrecardInfo> insertCrecard = new LazyCrecardInsert(option.conn, option.schemaName);	
		
		insertCuspar.addPostAction(insertCrecard);
		
		actions.add(insertCuspar);		
		return actions;
	}
}
