package br.com.mind5.business.feeDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.business.feeDefault.model.action.LazyFeedefSelect;
import br.com.mind5.business.feeDefault.model.action.StdFeedefEnforceCategServ;
import br.com.mind5.business.feeDefault.model.checker.FeedefCheckReadService;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFeedefSelectService extends DeciTreeTemplateRead<FeedefInfo> {
	
	public RootFeedefSelectService(DeciTreeOption<FeedefInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeedefInfo> buildCheckerHook(DeciTreeOption<FeedefInfo> option) {		
		List<ModelChecker<FeedefInfo>> queue = new ArrayList<>();		
		ModelChecker<FeedefInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeedefCheckReadService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
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
