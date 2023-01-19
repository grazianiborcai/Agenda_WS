package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.decisionTree;

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
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info.RecipaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action.RecipaVisiMergeBankacc;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action.RecipaVisiMergeStolis;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.action.RecipaVisiRootCreate;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.checker.RecipaCheckBankacc;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.checker.RecipaCheckCreateFromStore;
import br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.model.checker.RecipaCheckStore;

public final class RecipaRootCreateFromStore extends DeciTreeTemplateWrite<RecipaInfo> {
	
	public RecipaRootCreateFromStore(DeciTreeOption<RecipaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RecipaInfo> buildCheckerHook(DeciTreeOption<RecipaInfo> option) {
		List<ModelChecker<RecipaInfo>> queue = new ArrayList<>();		
		ModelChecker<RecipaInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RecipaCheckCreateFromStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RecipaCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RecipaCheckBankacc(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RecipaInfo>> buildActionsOnPassedHook(DeciTreeOption<RecipaInfo> option) {
		List<ActionStd<RecipaInfo>> actions = new ArrayList<>();
		
		ActionStd<RecipaInfo> mergeStolis = new ActionStdCommom<RecipaInfo>(option, RecipaVisiMergeStolis.class);
		ActionLazy<RecipaInfo> mergeBankacc = new ActionLazyCommom<RecipaInfo>(option, RecipaVisiMergeBankacc.class);
		ActionLazy<RecipaInfo> create = new ActionLazyCommom<RecipaInfo>(option, RecipaVisiRootCreate.class);
		
		mergeStolis.addPostAction(mergeBankacc);
		mergeBankacc.addPostAction(create);
		
		actions.add(mergeStolis);
		return actions;
	}
}
