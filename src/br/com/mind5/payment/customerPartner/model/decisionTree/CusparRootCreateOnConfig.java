package br.com.mind5.payment.customerPartner.model.decisionTree;

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
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiMergePayparult;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiNodeCreateOnConfigL1;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckHasPayPartner;

public final class CusparRootCreateOnConfig extends DeciTreeTemplateWrite<CusparInfo> {
	
	public CusparRootCreateOnConfig(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildCheckerHook(DeciTreeOption<CusparInfo> option) {		
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusparCheckHasPayPartner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();		

		ActionStd<CusparInfo> nodeL1 = new ActionStdCommom<CusparInfo>(option, CusparVisiNodeCreateOnConfigL1.class);
		
		actions.add(nodeL1);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnFailedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();		

		ActionStd <CusparInfo> mergePayparult = new ActionStdCommom <CusparInfo>(option, CusparVisiMergePayparult.class);
		ActionLazy<CusparInfo> nodeL1         = new ActionLazyCommom<CusparInfo>(option, CusparVisiNodeCreateOnConfigL1.class);
		
		mergePayparult.addPostAction(nodeL1);
		
		actions.add(mergePayparult);		
		return actions;
	}
}
