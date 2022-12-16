package br.com.mind5.config.payPartnerConfig.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.config.payPartnerConfig.model.action.PayrconfVisiMergeToSelect;
import br.com.mind5.config.payPartnerConfig.model.checker.PayrconfCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayrconfRootSelect extends DeciTreeTemplateRead<PayrconfInfo> {
	
	public PayrconfRootSelect(DeciTreeOption<PayrconfInfo> option) {
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
		checker = new PayrconfCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayrconfInfo>> buildActionsOnPassedHook(DeciTreeOption<PayrconfInfo> option) {
		List<ActionStd<PayrconfInfo>> actions = new ArrayList<>();

		ActionStd<PayrconfInfo> select = new ActionStdCommom<PayrconfInfo>(option, PayrconfVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
