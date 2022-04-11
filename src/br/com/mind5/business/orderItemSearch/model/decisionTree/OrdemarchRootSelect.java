package br.com.mind5.business.orderItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.action.OrdemarchVisiMergeToSelect;
import br.com.mind5.business.orderItemSearch.model.checker.OrdemarchCheckOwner;
import br.com.mind5.business.orderItemSearch.model.checker.OrdemarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrdemarchRootSelect extends DeciTreeTemplateWrite<OrdemarchInfo> {
	
	public OrdemarchRootSelect(DeciTreeOption<OrdemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemarchInfo> buildCheckerHook(DeciTreeOption<OrdemarchInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemarchInfo> option) {
		List<ActionStd<OrdemarchInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemarchInfo> select = new ActionStdCommom<OrdemarchInfo>(option, OrdemarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
