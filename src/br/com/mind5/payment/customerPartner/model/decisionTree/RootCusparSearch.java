package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparRootSelect;
import br.com.mind5.payment.customerPartner.model.action.StdCusparMergeCusparch;

public final class RootCusparSearch extends DeciTreeTemplateReadV2<CusparInfo> {
	
	public RootCusparSearch(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusparInfo> buildCheckerHook(DeciTreeOption<CusparInfo> option) {
		List<ModelCheckerV1<CusparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusparInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStdV1<CusparInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<CusparInfo> mergeCusparch = new StdCusparMergeCusparch(option);
		ActionLazyV1<CusparInfo> select = new LazyCusparRootSelect(option.conn, option.schemaName);
		
		mergeCusparch.addPostAction(select);
		
		actions.add(mergeCusparch);			
		return actions;
	}
}
