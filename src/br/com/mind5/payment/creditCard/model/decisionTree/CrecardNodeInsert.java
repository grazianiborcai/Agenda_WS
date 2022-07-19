package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiDaoInsert;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiEnforceUpperCase;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckCrecarch;

public final class CrecardNodeInsert extends DeciTreeTemplateWrite<CrecardInfo> {
	
	public CrecardNodeInsert(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;	
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new CrecardCheckCrecarch(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();	
		
		ActionStd<CrecardInfo> insertMoip = new CrecardNodeMoipInsert(option).toAction();
		ActionLazy<CrecardInfo> enforceUpperCase = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiEnforceUpperCase.class);	
		ActionLazy<CrecardInfo> insertCrecard = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiDaoInsert.class);	
		
		insertMoip.addPostAction(enforceUpperCase);
		enforceUpperCase.addPostAction(insertCrecard);
		
		actions.add(insertMoip);		
		return actions;
	}
}
