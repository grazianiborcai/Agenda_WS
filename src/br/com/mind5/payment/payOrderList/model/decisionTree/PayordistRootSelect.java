package br.com.mind5.payment.payOrderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.model.action.PayordistVisiMergeToSelect;
import br.com.mind5.payment.payOrderList.model.checker.PayordistCheckLangu;
import br.com.mind5.payment.payOrderList.model.checker.PayordistCheckOwner;
import br.com.mind5.payment.payOrderList.model.checker.PayordistCheckRead;

public final class PayordistRootSelect extends DeciTreeTemplateRead<PayordistInfo> {
	
	public PayordistRootSelect(DeciTreeOption<PayordistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordistInfo> buildCheckerHook(DeciTreeOption<PayordistInfo> option) {
		List<ModelChecker<PayordistInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordistCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordistCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordistCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordistInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordistInfo> option) {
		List<ActionStd<PayordistInfo>> actions = new ArrayList<>();		

		ActionStd<PayordistInfo> mergeToSelect = new ActionStdCommom<PayordistInfo>(option, PayordistVisiMergeToSelect.class);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
