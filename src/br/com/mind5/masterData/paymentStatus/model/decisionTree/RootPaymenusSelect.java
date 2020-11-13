package br.com.mind5.masterData.paymentStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.masterData.paymentStatus.model.action.StdPaymenusDaoSelect;
import br.com.mind5.masterData.paymentStatus.model.checker.PaymenusCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPaymenusSelect extends DeciTreeTemplateRead<PaymenusInfo> {
	
	public RootPaymenusSelect(DeciTreeOption<PaymenusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymenusInfo> buildCheckerHook(DeciTreeOption<PaymenusInfo> option) {
		List<ModelChecker<PaymenusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymenusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaymenusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<PaymenusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymenusInfo> option) {
		List<ActionStd<PaymenusInfo>> actions = new ArrayList<>();
		
		ActionStd<PaymenusInfo> select = new StdPaymenusDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
