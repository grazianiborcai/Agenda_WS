package br.com.mind5.business.orderItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.action.StdOrdemarchMergeToSelect;
import br.com.mind5.business.orderItemSearch.model.checker.OrdemarchCheckOwner;
import br.com.mind5.business.orderItemSearch.model.checker.OrdemarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootOrdemarchSelect extends DeciTreeTemplateWrite<OrdemarchInfo> {
	
	public RootOrdemarchSelect(DeciTreeOption<OrdemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdemarchInfo> buildCheckerHook(DeciTreeOption<OrdemarchInfo> option) {
		List<ModelCheckerV1<OrdemarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdemarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new OrdemarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new OrdemarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdemarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemarchInfo> option) {
		List<ActionStdV1<OrdemarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrdemarchInfo> select = new StdOrdemarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
