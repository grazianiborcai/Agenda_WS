package br.com.mind5.payment.payOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.action.PayordVisiMergeCrecard;
import br.com.mind5.payment.payOrder.model.action.PayordVisiMergeCuspar;
import br.com.mind5.payment.payOrder.model.action.PayordVisiMergePayordem;
import br.com.mind5.payment.payOrder.model.action.PayordVisiMergePaypar;
import br.com.mind5.payment.payOrder.model.action.PayordVisiMergeToSelect;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckLangu;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckRead;
import br.com.mind5.payment.payOrder.model.checker.PayordCheckUsername;

public final class PayordRootSelect extends DeciTreeTemplateRead<PayordInfo> {
	
	public PayordRootSelect(DeciTreeOption<PayordInfo> option) {
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

		ActionStd <PayordInfo> mergeToSelect = new ActionStdCommom <PayordInfo>(option, PayordVisiMergeToSelect.class);
		ActionLazy<PayordInfo> mergeCrecard  = new ActionLazyCommom<PayordInfo>(option, PayordVisiMergeCrecard.class);
		ActionLazy<PayordInfo> mergePaypar   = new ActionLazyCommom<PayordInfo>(option, PayordVisiMergePaypar.class);
		ActionLazy<PayordInfo> mergeCuspar   = new ActionLazyCommom<PayordInfo>(option, PayordVisiMergeCuspar.class);
		ActionLazy<PayordInfo> mergePayordem = new ActionLazyCommom<PayordInfo>(option, PayordVisiMergePayordem.class);
		
		mergeToSelect.addPostAction(mergeCrecard);
		mergeCrecard.addPostAction(mergePaypar);
		mergePaypar.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(mergePayordem);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
