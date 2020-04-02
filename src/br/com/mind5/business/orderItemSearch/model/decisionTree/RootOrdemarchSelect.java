package br.com.mind5.business.orderItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.action.StdOrdemarchMergeToSelect;
import br.com.mind5.business.orderItemSearch.model.checker.OrdemarchCheckOwner;
import br.com.mind5.business.orderItemSearch.model.checker.OrdemarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrdemarchSelect extends DeciTreeWriteTemplate<OrdemarchInfo> {
	
	public RootOrdemarchSelect(DeciTreeOption<OrdemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemarchInfo> buildDecisionCheckerHook(DeciTreeOption<OrdemarchInfo> option) {
		List<ModelChecker<OrdemarchInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemarchInfo> checker;	
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdemarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemarchInfo> option) {
		List<ActionStdV1<OrdemarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrdemarchInfo> select = new StdOrdemarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
