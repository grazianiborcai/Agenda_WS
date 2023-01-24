package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiMergeCuslis;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiMergeUselis;

public final class CusparNodeCus extends DeciTreeTemplateWrite<CusparInfo> {
	
	public CusparNodeCus(DeciTreeOption<CusparInfo> option) {
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
		
		ActionStd<CusparInfo> mergeCuslis = new ActionStdCommom<CusparInfo>(option, CusparVisiMergeCuslis.class);
		ActionLazy<CusparInfo> mergeUselis = new ActionLazyCommom<CusparInfo>(option, CusparVisiMergeUselis.class);
		
		mergeCuslis.addPostAction(mergeUselis);
		
		actions.add(mergeCuslis);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnFailedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();		

		ActionStd<CusparInfo> success = new ActionStdSuccessCommom<CusparInfo>(option);	
		
		actions.add(success);		
		return actions;
	}
}
