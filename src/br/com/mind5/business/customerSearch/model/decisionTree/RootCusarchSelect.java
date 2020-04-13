package br.com.mind5.business.customerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.action.LazyCusarchMergeToSelect;
import br.com.mind5.business.customerSearch.model.action.StdCusarchEnforceEntityCateg;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckOwner;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootCusarchSelect extends DeciTreeTemplateReadV1<CusarchInfo> {
	
	public RootCusarchSelect(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusarchInfo> buildCheckerHook(DeciTreeOption<CusarchInfo> option) {
		List<ModelCheckerV1<CusarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.SUCCESS;	
		checker = new CusarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CusarchInfo> option) {
		List<ActionStdV1<CusarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusarchInfo> enforceEntityCateg = new StdCusarchEnforceEntityCateg(option);
		ActionLazyV1<CusarchInfo> select = new LazyCusarchMergeToSelect(option.conn, option.schemaName);
		
		enforceEntityCateg.addPostAction(select);
		
		actions.add(enforceEntityCateg);
		return actions;
	}
}
