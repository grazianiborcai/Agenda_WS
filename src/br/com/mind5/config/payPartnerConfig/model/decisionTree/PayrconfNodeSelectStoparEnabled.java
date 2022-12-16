package br.com.mind5.config.payPartnerConfig.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.config.payPartnerConfig.model.checker.PayrconfCheckStoparEnabled;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayrconfNodeSelectStoparEnabled extends DeciTreeTemplateRead<PayrconfInfo> {
	
	public PayrconfNodeSelectStoparEnabled(DeciTreeOption<PayrconfInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayrconfInfo> buildCheckerHook(DeciTreeOption<PayrconfInfo> option) {
		List<ModelChecker<PayrconfInfo>> queue = new ArrayList<>();		
		ModelChecker<PayrconfInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new PayrconfCheckStoparEnabled(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayrconfInfo>> buildActionsOnPassedHook(DeciTreeOption<PayrconfInfo> option) {
		List<ActionStd<PayrconfInfo>> actions = new ArrayList<>();
		
		ActionStd<PayrconfInfo> success = new ActionStdSuccessCommom<PayrconfInfo>(option);	
		
		actions.add(success);		
		return actions;
	}
}
