package br.com.mind5.config.payPartnerStoreCreation.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerStoreCreation.info.PayrsocreInfo;
import br.com.mind5.config.payPartnerStoreCreation.model.action.PayrsocreVisiMergePayrconf;
import br.com.mind5.config.payPartnerStoreCreation.model.checker.PayrsocreCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayrsocreRootSelect extends DeciTreeTemplateRead<PayrsocreInfo> {
	
	public PayrsocreRootSelect(DeciTreeOption<PayrsocreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayrsocreInfo> buildCheckerHook(DeciTreeOption<PayrsocreInfo> option) {
		List<ModelChecker<PayrsocreInfo>> queue = new ArrayList<>();		
		ModelChecker<PayrsocreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new PayrsocreCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayrsocreInfo>> buildActionsOnPassedHook(DeciTreeOption<PayrsocreInfo> option) {
		List<ActionStd<PayrsocreInfo>> actions = new ArrayList<>();

		ActionStd<PayrsocreInfo> mergePayrconf = new ActionStdCommom<PayrsocreInfo>(option, PayrsocreVisiMergePayrconf.class);
		
		actions.add(mergePayrconf);
		return actions;
	}
}
