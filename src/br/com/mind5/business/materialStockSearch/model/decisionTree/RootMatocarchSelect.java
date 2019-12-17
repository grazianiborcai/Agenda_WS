package br.com.mind5.business.materialStockSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.business.materialStockSearch.model.action.StdMatocarchMergeToSelect;
import br.com.mind5.business.materialStockSearch.model.checker.MatocarchCheckLangu;
import br.com.mind5.business.materialStockSearch.model.checker.MatocarchCheckOwner;
import br.com.mind5.business.materialStockSearch.model.checker.MatocarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;


public final class RootMatocarchSelect extends DeciTreeReadTemplate<MatocarchInfo> {
	
	public RootMatocarchSelect(DeciTreeOption<MatocarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatocarchInfo> buildDecisionCheckerHook(DeciTreeOption<MatocarchInfo> option) {
		List<ModelChecker<MatocarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatocarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatocarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatocarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatocarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatocarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatocarchInfo> option) {
		List<ActionStd<MatocarchInfo>> actions = new ArrayList<>();

		ActionStd<MatocarchInfo> select = new StdMatocarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
