package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeInsertCremoip;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeUpsert;
import br.com.mind5.payment.creditCard.model.action.StdCrecardInsertCuspar;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckHasPaypar;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUserAddress;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUserPhone;

public final class NodeCrecardInsertL2 extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public NodeCrecardInsertL2(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;	
		
		checker = new CrecardCheckHasPaypar();
		queue.add(checker);
		
		checker = new CrecardCheckUserAddress();
		queue.add(checker);
		
		checker = new CrecardCheckUserPhone();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo> insertCuspar = new  StdCrecardInsertCuspar(option);
		ActionLazy<CrecardInfo> nodeMoip = new LazyCrecardNodeInsertCremoip(option.conn, option.schemaName);	
		ActionLazy<CrecardInfo> upsertCrecard = new LazyCrecardNodeUpsert(option.conn, option.schemaName);	
		
		insertCuspar.addPostAction(nodeMoip);
		nodeMoip.addPostAction(upsertCrecard);
		
		actions.add(insertCuspar);		
		return actions;
	}
}
