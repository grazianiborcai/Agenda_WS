package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergeCrecard;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergePayordem;
import br.com.mind5.payment.payOrder.model.action.LazyPayordMergePaypar;
import br.com.mind5.payment.payOrder.model.action.StdPayordMergeToSelect;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckLangu;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckRead;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckUsername;

public final class RootPayordSelect extends DeciTreeTemplateReadV2<PayordInfo> {
	
	public RootPayordSelect(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordInfo> buildCheckerHook(DeciTreeOption<PayordInfo> option) {
		List<ModelCheckerV1<PayordInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PayordInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordInfo> option) {
		List<ActionStdV2<PayordInfo>> actions = new ArrayList<>();		

		ActionStdV2<PayordInfo> mergeToSelect = new StdPayordMergeToSelect(option);
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
