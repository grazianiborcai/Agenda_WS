package br.com.gda.business.feeDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.business.feeDefault.model.action.LazyFeedefSelect;
import br.com.gda.business.feeDefault.model.action.StdFeedefEnforceCategServ;
import br.com.gda.business.feeDefault.model.checker.FeedefCheckReadService;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootFeedefSelectService extends DeciTreeReadTemplate<FeedefInfo> {
	
	public RootFeedefSelectService(DeciTreeOption<FeedefInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeedefInfo> buildDecisionCheckerHook(DeciTreeOption<FeedefInfo> option) {		
		List<ModelChecker<FeedefInfo>> queue = new ArrayList<>();		
		ModelChecker<FeedefInfo> checker;
		
		checker = new FeedefCheckReadService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FeedefInfo>> buildActionsOnPassedHook(DeciTreeOption<FeedefInfo> option) {
		List<ActionStd<FeedefInfo>> actions = new ArrayList<>();
		
		ActionStd<FeedefInfo> enforceCateg = new StdFeedefEnforceCategServ(option);
		ActionLazy<FeedefInfo> mergeMat = new LazyFeedefSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(mergeMat);		
		
		actions.add(enforceCateg);
		return actions;
	}
}
