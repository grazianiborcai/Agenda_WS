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
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodePayPartnerL1;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeSearchL1;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckSearch;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;

public final class CrecardRootSearch extends DeciTreeTemplateRead<CrecardInfo> {
	
	public CrecardRootSearch(DeciTreeOption<CrecardInfo> option) {
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
		checker = new CrecardCheckSearch(checkerOption);
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
		
		ActionStd<CrecardInfo>  nodeUser       = new CrecardNodeUser(option).toAction();
		ActionLazy<CrecardInfo> nodePayPartner = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodePayPartnerL1.class);
		ActionLazy<CrecardInfo> nodeL1         = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeSearchL1.class);		
		
		nodeUser.addPostAction(nodePayPartner);
		nodePayPartner.addPostAction(nodeL1);
		
		actions.add(nodeUser);
		return actions;
	}
}
