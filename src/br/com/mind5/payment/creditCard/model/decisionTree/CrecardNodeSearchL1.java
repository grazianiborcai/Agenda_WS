package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdDataNotFoundCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiMergeCrecarch;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiMergeCusparch;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiRootSelect;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckCusparch;

public final class CrecardNodeSearchL1 extends DeciTreeTemplateWrite<CrecardInfo> {
	
	public CrecardNodeSearchL1(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckCusparch(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo>  mergeCusparch = new ActionStdCommom< CrecardInfo>(option, CrecardVisiMergeCusparch.class);
		ActionLazy<CrecardInfo> mergeCrecarch = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiMergeCrecarch.class);
		ActionLazy<CrecardInfo> select        = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiRootSelect.class);
		
		actions.add(mergeCusparch);
		mergeCusparch.addPostAction(mergeCrecarch);
		mergeCrecarch.addPostAction(select);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnFailedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo> dataNotFound = new ActionStdDataNotFoundCommom<CrecardInfo>(option);
		
		actions.add(dataNotFound);		
		return actions;
	}
}
