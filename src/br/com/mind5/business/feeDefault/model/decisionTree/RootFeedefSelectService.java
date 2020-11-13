package br.com.mind5.business.feeDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.business.feeDefault.model.action.LazyFeedefSelect;
import br.com.mind5.business.feeDefault.model.action.StdFeedefEnforceCategServ;
import br.com.mind5.business.feeDefault.model.checker.FeedefCheckReadService;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFeedefSelectService extends DeciTreeTemplateReadV2<FeedefInfo> {
	
	public RootFeedefSelectService(DeciTreeOption<FeedefInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FeedefInfo> buildCheckerHook(DeciTreeOption<FeedefInfo> option) {		
		List<ModelCheckerV1<FeedefInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FeedefInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FeedefCheckReadService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FeedefInfo>> buildActionsOnPassedHook(DeciTreeOption<FeedefInfo> option) {
		List<ActionStdV2<FeedefInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FeedefInfo> enforceCateg = new StdFeedefEnforceCategServ(option);
		ActionLazy<FeedefInfo> mergeMat = new LazyFeedefSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(mergeMat);		
		
		actions.add(enforceCateg);
		return actions;
	}
}
