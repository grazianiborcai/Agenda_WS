package br.com.mind5.config.payPartnerCustomerCreation.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerCustomerCreation.info.PayrcucreInfo;
import br.com.mind5.config.payPartnerCustomerCreation.model.checker.PayrcucreCheckConfig;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayrcucreNodeSelectEnabled extends DeciTreeTemplateRead<PayrcucreInfo> {
	
	public PayrcucreNodeSelectEnabled(DeciTreeOption<PayrcucreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayrcucreInfo> buildCheckerHook(DeciTreeOption<PayrcucreInfo> option) {
		List<ModelChecker<PayrcucreInfo>> queue = new ArrayList<>();		
		ModelChecker<PayrcucreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new PayrcucreCheckConfig(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayrcucreInfo>> buildActionsOnPassedHook(DeciTreeOption<PayrcucreInfo> option) {
		List<ActionStd<PayrcucreInfo>> actions = new ArrayList<>();
		
		ActionStd<PayrcucreInfo> success = new ActionStdSuccessCommom<PayrcucreInfo>(option);	
		
		actions.add(success);		
		return actions;
	}
}
