package br.com.mind5.masterData.paymentPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.action.PayparVisiDaoSelect;
import br.com.mind5.masterData.paymentPartner.model.checker.PayparCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayparRootSelect extends DeciTreeTemplateRead<PayparInfo> {
	
	public PayparRootSelect(DeciTreeOption<PayparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayparInfo> buildCheckerHook(DeciTreeOption<PayparInfo> option) {
		List<ModelChecker<PayparInfo>> queue = new ArrayList<>();		
		ModelChecker<PayparInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<PayparInfo>> buildActionsOnPassedHook(DeciTreeOption<PayparInfo> option) {
		List<ActionStd<PayparInfo>> actions = new ArrayList<>();
		
		ActionStd<PayparInfo> select = new ActionStdCommom<PayparInfo>(option, PayparVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
