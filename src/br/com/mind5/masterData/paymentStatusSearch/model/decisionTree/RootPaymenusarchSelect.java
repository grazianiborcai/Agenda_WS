package br.com.mind5.masterData.paymentStatusSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;
import br.com.mind5.masterData.paymentStatusSearch.model.action.StdPaymenusarchDaoSelect;
import br.com.mind5.masterData.paymentStatusSearch.model.checker.PaymenusarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPaymenusarchSelect extends DeciTreeTemplateRead<PaymenusarchInfo> {
	
	public RootPaymenusarchSelect(DeciTreeOption<PaymenusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymenusarchInfo> buildCheckerHook(DeciTreeOption<PaymenusarchInfo> option) {
		List<ModelChecker<PaymenusarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymenusarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaymenusarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<PaymenusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymenusarchInfo> option) {
		List<ActionStd<PaymenusarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PaymenusarchInfo> select = new StdPaymenusarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
