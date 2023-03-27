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
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiMergePayparult;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodePayPartnerL2;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckHasPayPartner;

public final class CrecardNodePayPartnerL1 extends DeciTreeTemplateWrite<CrecardInfo> {
	
	public CrecardNodePayPartnerL1(DeciTreeOption<CrecardInfo> option) {
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
		checker = new CrecardCheckHasPayPartner(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();	
		
		ActionStd<CrecardInfo> nodeL2 = new ActionStdCommom<CrecardInfo>(option, CrecardVisiNodePayPartnerL2.class);
		
		actions.add(nodeL2);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnFailedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();	
		
		ActionStd <CrecardInfo> mergerPayparult = new ActionStdCommom <CrecardInfo>(option, CrecardVisiMergePayparult.class);
		ActionLazy<CrecardInfo> nodeL2          = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodePayPartnerL2.class);
		
		mergerPayparult.addPostAction(nodeL2);
		
		actions.add(mergerPayparult);		
		return actions;
	}
}
