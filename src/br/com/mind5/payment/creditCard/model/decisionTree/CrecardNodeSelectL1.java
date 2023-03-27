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
import br.com.mind5.payment.creditCard.model.action.CrecardVisiMergePhonap;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeSelectL2;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckHasPhonap;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckHasPhone;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckPhonap;

public final class CrecardNodeSelectL1 extends DeciTreeTemplateRead<CrecardInfo> {
	
	public CrecardNodeSelectL1(DeciTreeOption<CrecardInfo> option) {
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
		checker = new CrecardCheckHasPhone(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckHasPhonap(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckPhonap(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		
		
		ActionStd <CrecardInfo> mergePhonap = new ActionStdCommom <CrecardInfo>(option, CrecardVisiMergePhonap.class);
		ActionLazy<CrecardInfo> nodeL2      = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeSelectL2.class);
		
		mergePhonap.addPostAction(nodeL2);
		
		
		actions.add(mergePhonap);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnFailedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo> nodeL2 = new CrecardNodeSelectL2(option).toAction();	
		
		actions.add(nodeL2);		
		return actions;
	}
}
