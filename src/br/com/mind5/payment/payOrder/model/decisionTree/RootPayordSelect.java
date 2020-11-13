package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeCrecard;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergePayordem;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergePaypar;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeToSelect;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckLangu;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckRead;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckUsername;

public final class RootPayordSelect extends DeciTreeTemplateRead<PayordInfo> {
	
	public RootPayordSelect(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelChecker<PayordInfo>> queue = new ArrayList<>();		
		ModelChecker<PayordInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStd<PayordInfo>> actions = new ArrayList<>();		

		ActionStd<PayordInfo> mergeToSelect = new StdPayordMergeToSelect(option);
		ActionLazy<PayordInfo> mergeCrecard = new LazyPayordMergeCrecard(option.conn, option.schemaName);
		ActionLazy<PayordInfo> mergePaypar = new LazyPayordMergePaypar(option.conn, option.schemaName);
		ActionLazy<PayordInfo> mergePayordem = new LazyPayordMergePayordem(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeCrecard);
		mergeCrecard.addPostAction(mergePaypar);
		mergePaypar.addPostAction(mergePayordem);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
