package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparRootSelect;
import br.com.mind5.payment.customerPartner.model.action.StdCusparMergeCusparch;

public final class RootCusparSearch extends DeciTreeTemplateRead<CusparInfo> {
	
	public RootCusparSearch(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildCheckerHook(DeciTreeOption<CusparInfo> option) {
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();		
		
		ActionStd<CusparInfo> mergeCusparch = new StdCusparMergeCusparch(option);
		ActionLazy<CusparInfo> select = new LazyCusparRootSelect(option.conn, option.schemaName);
		
		mergeCusparch.addPostAction(select);
		
		actions.add(mergeCusparch);			
		return actions;
	}
}
