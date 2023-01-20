package br.com.mind5.config.payPartnerCustomerCreation.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerCustomerCreation.info.PayrcucreInfo;
import br.com.mind5.config.payPartnerCustomerCreation.model.action.PayrcucreVisiMergePayrconf;
import br.com.mind5.config.payPartnerCustomerCreation.model.checker.PayrcucreCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayrcucreRootSelect extends DeciTreeTemplateRead<PayrcucreInfo> {
	
	public PayrcucreRootSelect(DeciTreeOption<PayrcucreInfo> option) {
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
		checker = new PayrcucreCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayrcucreInfo>> buildActionsOnPassedHook(DeciTreeOption<PayrcucreInfo> option) {
		List<ActionStd<PayrcucreInfo>> actions = new ArrayList<>();

		ActionStd<PayrcucreInfo> mergePayrconf = new ActionStdCommom<PayrcucreInfo>(option, PayrcucreVisiMergePayrconf.class);
		
		actions.add(mergePayrconf);
		return actions;
	}
}
