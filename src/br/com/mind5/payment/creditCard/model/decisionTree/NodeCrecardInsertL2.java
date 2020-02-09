package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeInsertCremoip;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeUpsert;
import br.com.mind5.payment.creditCard.model.action.StdCrecardInsertCuspar;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckAddarch;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckCusparch;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckHasPaypar;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckPhonarch;

public final class NodeCrecardInsertL2 extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public NodeCrecardInsertL2(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckHasPaypar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new CrecardCheckCusparch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckAddarch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckPhonarch(checkerOption);
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
