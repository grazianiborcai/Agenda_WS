package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiNodeCusmoipCreate;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiDaoInsert;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiDaoUpdate;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiEnforceCompoundId;

public final class CusparNodeInsert extends DeciTreeTemplateWrite<CusparInfo> {
	
	public CusparNodeInsert(DeciTreeOption<CusparInfo> option) {
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
		
		ActionStd<CusparInfo> insert = new ActionStdCommom<CusparInfo>(option, CusparVisiDaoInsert.class);
		ActionLazy<CusparInfo> enforceCompoundId = new ActionLazyCommom<CusparInfo>(option, CusparVisiEnforceCompoundId.class);	
		ActionLazy<CusparInfo> createMoip = new ActionLazyCommom<CusparInfo>(option, CusparVisiNodeCusmoipCreate.class);
		ActionLazy<CusparInfo> update = new ActionLazyCommom<CusparInfo>(option, CusparVisiDaoUpdate.class);
		
		insert.addPostAction(enforceCompoundId);
		enforceCompoundId.addPostAction(createMoip);
		createMoip.addPostAction(update);
		
		actions.add(insert);
		return actions;
	}
}
