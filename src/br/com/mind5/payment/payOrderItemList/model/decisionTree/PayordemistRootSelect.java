package br.com.mind5.payment.payOrderItemList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.action.PayordemistVisiMergeToSelect;
import br.com.mind5.payment.payOrderItemList.model.checker.PayordemistCheckRead;

public final class PayordemistRootSelect extends DeciTreeTemplateWrite<PayordemistInfo> {
	
	public PayordemistRootSelect(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordemistInfo> buildCheckerHook(DeciTreeOption<PayordemistInfo> option) {
		List<ModelChecker<PayordemistInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordemistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordemistCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordemistInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemistInfo> option) {
		List<ActionStd<PayordemistInfo>> actions = new ArrayList<>();
		
		ActionStd<PayordemistInfo> select = new ActionStdCommom<PayordemistInfo>(option, PayordemistVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
