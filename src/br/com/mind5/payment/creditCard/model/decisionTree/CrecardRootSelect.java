package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiEnforceExpired;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiMergeCuspar;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiMergePaypar;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiMergeToSelect;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckOwner;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckRead;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class CrecardRootSelect extends DeciTreeTemplateRead<CrecardInfo> {
	
	public CrecardRootSelect(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new CrecardCheckUsername(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();
		
		ActionStd<CrecardInfo> mergeToSelect = new ActionStdCommom<CrecardInfo>(option, CrecardVisiMergeToSelect.class);
		ActionLazy<CrecardInfo> enforceExpired = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiEnforceExpired.class);
		ActionLazy<CrecardInfo> mergeCuspar = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiMergeCuspar.class);
		ActionLazy<CrecardInfo> mergePaypar = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiMergePaypar.class);
		
		mergeToSelect.addPostAction(enforceExpired);
		enforceExpired.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(mergePaypar);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
